/**
 * @author xingzhou
 * @date 2019/12/8 22:33
 * @version 1.0
 */

package xmu.oomall.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageHelper;
import com.netflix.client.http.HttpRequest;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.awt.image.SurfaceManager;
import xmu.oomall.controller.GoodsController;
import xmu.oomall.dao.FreightDao;
import xmu.oomall.dao.GoodsDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.FreightService;
import xmu.oomall.util.AddressResolutionUtil;
import xmu.oomall.util.JacksonUtil;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 运费的service实现类
 *
 */
@Service
public class FreightServiceImpl implements FreightService {
    @Autowired
    private FreightDao freightDao;
    @Autowired
    private  GoodsController controller;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private GoodsPo findGoodsPoById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("Goods");
        String reqURL = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/test/goods/" + id);
        return restTemplate.getForObject(reqURL, GoodsPo.class);
    }

    /**
     * 查找默认运费
     *
     * @return 默认运费模板列表
     */
    @Override
    public List<DefaultFreightPo> findDefaultFreightsList(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        return freightDao.findDefaultFreightList();
    }

    /**
     * 查找默认运费比率表
     *
     * @return 默认运费比率表
     */
    @Override
    public List<DefaultPieceFreightPo> findDefaultPieceFreightList(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        return freightDao.findDefaultPieceFreightList();
    }

    /**
     * 添加默认运费模板
     *
     * @param defaultFreightPo
     * @return 操作成功与否
     */
    @Override
    public int addDefaultFreights(DefaultFreightPo defaultFreightPo) {
        return freightDao.addDefaultFreight(defaultFreightPo);
    }

    /**
     * 添加默认运费比率
     *
     * @param defaultPieceFreightPo
     * @return 操作码
     */
    @Override
    public int addDefaultPieceFreights(DefaultPieceFreightPo defaultPieceFreightPo) {
        return freightDao.addDefaultPieceFreight(defaultPieceFreightPo);
    }

    /**
     * 删除默认运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    @Override
    public int deleteDefaultFreight(Integer id) {
        return freightDao.deleteDefaultFreightById(id);
    }

    /**
     * 删除默认运费比率
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteDefaultPieceFreight(Integer id) {
        return freightDao.deleteDefaultPieceFreightById(id);
    }

    /**
     * 更新默认运费比率
     *
     * @param defaultPieceFreightPo
     * @return 操作码
     */
    @Override
    public int updateDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo) {
        return freightDao.updateDefaultPieceFreight(defaultPieceFreightPo);
    }


    /**
     * 更新默认运费模板
     *
     * @param defaultFreightPo
     * @return 操作成功与否
     */
    @Override
    public int updateDefaultFreight(DefaultFreightPo defaultFreightPo) {
        return freightDao.updateDefaultFreight(defaultFreightPo);
    }

    /**
     * 计算运费所需要的值
     *
     * @param order
     * @return 计算好的运费
     */
    @Override
    public double getFreight(Order order) {
        //思路：
        /*
        先从找到order对应的orderitem
        然后根据orderitem对应的goods判断商品的运费模板的模式
        然后根据运费模板计算运费。。。
         */
        if(order==null) {
            return -1;
        }
        //此处本应调用order模块
        List <OrderItem> orderItemList=freightDao.findItemsInAOrder(order);
        List<Integer> SpecialFreightID = new ArrayList<>();
        System.out.println("test1");
        //记录特殊模板的id
        List<Double> weight= new ArrayList<>();
        System.out.println("test*********");
        //记录每个商品的重量
        List<Integer> nums= new ArrayList<>();
        //记录每个商品的件数
        System.out.println("test*********");
        String address=order.getAddress();
        System.out.println("test*********");
        System.out.println(AddressResolutionUtil.addressResolution(address).size());
        Map<String,String> addressInfo = AddressResolutionUtil.addressResolution(address).get(0);
        System.out.println("test???????");
        String province=addressInfo.get("province");
        String city=addressInfo.get("city");
        String county=addressInfo.get("county");
        List<Integer> addresscode = new ArrayList<>();
        if(freightDao.findIdFromRegion1(county,freightDao.findIdFromRegion(city))!=null)
        {
            addresscode.add(freightDao.findIdFromRegion1(county,freightDao.findIdFromRegion(city)));
        }
        System.out.println("99999");
        if(freightDao.findIdFromRegion1(city,freightDao.findIdFromRegion(province))!=null)
        {
            System.out.println("99999");
            addresscode.add(freightDao.findIdFromRegion1(city,freightDao.findIdFromRegion(province)));
        }
        if(freightDao.findIdFromRegion(province)!=null)
        {
            addresscode.add(freightDao.findIdFromRegion(province).get(0));
        }
        System.out.println("test!!!!!");
        //订单配送地址
        for(OrderItem orderItem:orderItemList)
        {
            Integer goodsId=orderItem.getGoodsId();
            //调用商品服务中的findgoodsbyid查看其运费模板类别
            //暂时不知道怎么调用，先占位模拟逻辑过程
            GoodsPo goodsPo=new GoodsPo();
            System.out.println("99999");
            goodsPo= findGoodsPoById(goodsId);
            System.out.println(goodsPo);
            System.out.println("99999");
            if(goodsPo.getBeSpecial())
            {
                SpecialFreightID.add(goodsPo.getSpecialFreightId());
            }
            weight.add(goodsPo.getWeight().doubleValue()*orderItem.getNumber());
            nums.add(orderItem.getNumber());
        }
        double freeFreightPrice =88;
        //包邮的阀值价格
        if(order.getGoodsPrice().doubleValue()>=freeFreightPrice) {
            return 0;
        }
        System.out.println("test2");
        //？？？？？？？？？？？？
        //要将所有的模板放到redis中方便频繁查询
        //？？？？？？？？？？？？
        //先计算默认运费模板：
        double defaultPrice=0.0;
        DefaultFreight defaultFreight = null;
        //defaultFreight=find(address,DefaultFreightRedis);
        //通过address找到对应的默认运费模板
        List<DefaultFreightPo> defaultFreightPoList=freightDao.findDefaultFreightList();
        List<DefaultFreight> defaultFreightList = new ArrayList<>();
        for(DefaultFreightPo defaultFreightPo1:defaultFreightPoList)
        {
            DefaultFreight defaultFreight1=new DefaultFreight();
            defaultFreight1.setRegionIds(JacksonUtil.parseIntegerList(defaultFreightPo1.getDestination(), "dest"));
            defaultFreight1.setFirstHeavyPrice(defaultFreightPo1.getFirstHeavyPrice());
            defaultFreight1.setContinueHeavyPrice(defaultFreightPo1.getContinueHeavyPrice());
            defaultFreight1.setOver10Price(defaultFreightPo1.getOver10Price());
            defaultFreight1.setOver50Price(defaultFreightPo1.getOver50Price());
            defaultFreight1.setOver100Price(defaultFreightPo1.getOver100Price());
            defaultFreight1.setOver300Price(defaultFreightPo1.getOver300Price());
            defaultFreightList.add(defaultFreight1);
        }
        boolean find=false;
        for(Integer temp :addresscode)
        {
            for(DefaultFreight defaultFreight1:defaultFreightList)
            {
                if(defaultFreight1.getRegionIds().contains(temp))
                {
                    defaultFreight=defaultFreight1;
                    find=true;
                    break;
                }
            }
            if(find==true)
            {
                break;
            }
        }
        double weightsum=weight.stream().reduce(Double::sum).orElse(0.0);
        double firstHevay=0.5;
        double continueHeavy=10.0;
        double thirdHeavy=50.0;
        double fourthHeavy=100.0;
        double topHeavy=300.0;
        if(weightsum<=firstHevay)
        {
            defaultPrice=defaultFreight.getFirstHeavyPrice().doubleValue();
        }
        else if(weightsum>firstHevay&&weightsum<=continueHeavy)
        {
            defaultPrice=defaultFreight.getFirstHeavyPrice().doubleValue()+defaultFreight.getContinueHeavyPrice().doubleValue()*((weightsum-0.5)/0.5);
        }
        else if(weightsum>continueHeavy&&weightsum<=thirdHeavy)
        {
            defaultPrice+=defaultFreight.getFirstHeavyPrice().doubleValue();
            defaultPrice+=defaultFreight.getContinueHeavyPrice().doubleValue()*19.0;
            defaultPrice+=defaultFreight.getOver10Price().doubleValue()*(weightsum-10.0);
        }
        else if(weightsum>thirdHeavy&&weightsum<=fourthHeavy)
        {
            defaultPrice+=defaultFreight.getFirstHeavyPrice().doubleValue();
            defaultPrice+=defaultFreight.getContinueHeavyPrice().doubleValue()*19.0;
            defaultPrice+=defaultFreight.getOver10Price().doubleValue()*(40.0);
            defaultPrice+=defaultFreight.getOver50Price().doubleValue()*(weightsum-50.0);
        }
        else if(weightsum>fourthHeavy&&weightsum<=topHeavy)
        {
            defaultPrice+=defaultFreight.getFirstHeavyPrice().doubleValue();
            defaultPrice+=defaultFreight.getContinueHeavyPrice().doubleValue()*19.0;
            defaultPrice+=defaultFreight.getOver10Price().doubleValue()*(40.0);
            defaultPrice+=defaultFreight.getOver50Price().doubleValue()*(50.0);
            defaultPrice+=defaultFreight.getOver100Price().doubleValue()*(weightsum-100.0);
        }
        else
        {
            defaultPrice+=defaultFreight.getFirstHeavyPrice().doubleValue();
            defaultPrice+=defaultFreight.getContinueHeavyPrice().doubleValue()*19.0;
            defaultPrice+=defaultFreight.getOver10Price().doubleValue()*(40.0);
            defaultPrice+=defaultFreight.getOver50Price().doubleValue()*(50.0);
            defaultPrice+=defaultFreight.getOver100Price().doubleValue()*(200.0);
            defaultPrice+=defaultFreight.getOver300Price().doubleValue()*(weightsum-300.0);
        }

        //再计算特殊运费模板(多种特殊运费模板)：
        System.out.println("test3");
        List<Double> specialPrice = new ArrayList<>();
        Integer numsAll=nums.stream().reduce(Integer::sum).orElse(0);
        for(Integer id:SpecialFreightID)
        {
            SpecialFreight specialFreight=freightDao.findSpecialFreightById(id);
            if(specialFreight!=null)
            {
                //从redis中取单件比率表
                DefaultPieceFreight defaultPieceFreight=null;
                //defaultPieceFreight=find(address,specialFreightRedis);
                List<DefaultPieceFreightPo> defaultPieceFreightPoList=freightDao.findDefaultPieceFreightList();
                List<DefaultPieceFreight> defaultPieceFreightList = new ArrayList<>();
                for(DefaultPieceFreightPo defaultPieceFreightPo:defaultPieceFreightPoList)
                {
                    DefaultPieceFreight defaultPieceFreight1=new DefaultPieceFreight();
                    defaultPieceFreight1.setRegionIds(JacksonUtil.parseIntegerList(defaultPieceFreightPo.getDestination(), "dest"));
                    defaultPieceFreight1.setUnitRate(defaultPieceFreightPo.getUnitRate());
                    defaultPieceFreightList.add(defaultPieceFreight1);
                }
                boolean find1=false;
                for(Integer temp :addresscode)
                {
                    for(DefaultPieceFreight defaultPieceFreight1:defaultPieceFreightList)
                    {
                        if(defaultPieceFreight1.getRegionIds().contains(temp))
                        {
                            defaultPieceFreight=defaultPieceFreight1;
                            find1=true;
                            break;
                        }
                    }
                    if(find1==true)
                    {
                        break;
                    }
                }
                if(numsAll<=specialFreight.getFirstNumPiece())
                {
                    specialPrice.add(numsAll*specialFreight.getFirstNumPiecePrice().doubleValue()*defaultPieceFreight.getUnitRate().doubleValue());
                }
                else
                {
                    double temp=0.0;
                    temp+=specialFreight.getFirstNumPiece()*specialFreight.getFirstNumPiecePrice().doubleValue()*defaultPieceFreight.getUnitRate().doubleValue();
                    Integer n;
                    if((numsAll-specialFreight.getFirstNumPiece())%specialFreight.getContinueNumPiece()==0)
                    {
                        n = (numsAll-specialFreight.getFirstNumPiece())/specialFreight.getContinueNumPiece();
                    }
                    else {
                        n = (numsAll-specialFreight.getFirstNumPiece())/specialFreight.getContinueNumPiece()+1;
                    }
                    temp+=n*specialFreight.getContinueNumPiecePrice().doubleValue()*defaultPieceFreight.getUnitRate().doubleValue();
                    specialPrice.add(temp);
                }
            }
        }
        System.out.println("test4");
        double specialPriceMax=specialPrice.stream().max((a, b) -> {
            if (a > b) {
                return 1;
            } else {
                return -1;
            }
        }).get();
        if(specialPriceMax>defaultPrice)
        {
            return specialPriceMax;
        }
        else
        {
            return defaultPrice;
        }

    }

    /**
     * 通过id查找默认运费模板
     *
     * @param id
     * @return 默认运费模板
     */
    @Override
    public DefaultFreight findDefaultFreightsById(Integer id) {

        return freightDao.findDefaultFreightById(id);
    }

    /**
     * 通过id查找默认运费比率
     *
     * @param id
     * @return 默认运费比率
     */
    @Override
    public DefaultPieceFreightPo findDefaultPieceFreightById(Integer id) {
        return freightDao.findDefaultPieceFreightById(id);
    }

    /**
     * 查看所有特殊运费
     *
     * @param page
     * @param limit
     * @return 特殊运费模板列表
     */
    @Override
    public List<SpecialFreight> findSpecialFreightList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return freightDao.findSpecialFreightList();
    }

    /**
     * 通过id查找特殊运费模板
     *
     * @param id
     * @return 特殊运费模板
     */
    @Override
    public SpecialFreight findSpecialFreightById(Integer id) {
        return freightDao.findSpecialFreightById(id);
    }

    /**
     * 新增特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    @Override
    public int addSpecialFreight(SpecialFreight specialFreight) {
        return freightDao.addSpecialFreight(specialFreight);
    }

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteSpecialFreight(Integer id) {
        return freightDao.deleteSpecialFreight(id);
    }

    /**
     * 更新特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    @Override
    public int updateSpecialFreight(SpecialFreight specialFreight) {
        return freightDao.updateSpecialFreight(specialFreight);
    }


}
