/**
 * @author xingzhou
 * @date 2019/12/7 23:47
 * @version 1.0
 */

package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.domain.*;
import xmu.oomall.service.BrandService;
import xmu.oomall.service.GoodsCategoryService;
import xmu.oomall.service.GoodsService;
import xmu.oomall.service.ProductService;
import xmu.oomall.util.JacksonUtil;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class GoodsController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/admin/brands")
    @ApiOperation(value="根据条件搜索品牌/list")
    public Object adminFindBrandList(HttpServletRequest request,
                                    @RequestParam("BrandId") Integer id,
                                    @RequestParam("BrandName") String name,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer limit)
    {
        List<BrandPo> brandList= brandService.findBrandListByIdAndName(id,name,page,limit);
        if(brandList.size()==0){
            Log log=createLog(request, 0, 0, "查询品牌列表",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(795,"获取品牌列表失败");
        }
        else{
            Log log=createLog(request, 0, 1, "查询品牌列表",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(brandList);
        }
    };

    @PostMapping("/brands")
    @ApiOperation(value = "创建一个品牌/create")
    public Object addBrand(HttpServletRequest request,@RequestBody BrandPo brandPo){
        BrandPo retPo=brandService.addBrand(brandPo);
        if(retPo==null) {
            Log log=createLog(request, 0, 0, "添加品牌",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(791,"品牌新增失败");
        }
        else {
            Log log = createLog(request, 0, 1, "添加品牌",null);
            if (log != null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };

    @GetMapping("/admin/brands/{id}")
    @ApiOperation(value="查看单个品牌信息/read")
    public Object adminFindBrandById(HttpServletRequest request,@PathVariable Integer id){
        BrandPo brandPo= brandService.findBrandById(id);
        if(brandPo==null){
            Log log = createLog(request, 0, 0, "查看单个品牌",id);
            if (log != null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(794,"该品牌不存在");
        }
        else {
            Log log = createLog(request, 0, 1, "查看单个品牌",id);
            if (log != null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(brandPo);
        }
    };


    @PutMapping("/brands/{id}")
    @ApiOperation(value="修改单个品牌的信息/update")
    public Object updateBrand(HttpServletRequest request,
                              @PathVariable Integer id,
                              @RequestBody BrandPo brandPo)
    {
        brandPo.setId(id);
        BrandPo retPo= brandService.updateBrand(brandPo);
        if(retPo==null){
            Log log=createLog(request, 0, 0, "更新品牌",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(792,"品牌修改失败");
        }
        else{
            Log log=createLog(request, 0, 1, "更新品牌",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };


    @DeleteMapping("/brands/{id}")
    @ApiOperation(value = "删除一个品牌/delete")
    public Object deleteBrand(HttpServletRequest request,@PathVariable Integer id){
        int ret= brandService.deleteBrand(id);
        if(ret==0){
            Log log=createLog(request, 0, 0, "删除品牌",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(794,"该品牌不存在");
        }
        else {
            Log log=createLog(request, 0, 1, "删除品牌",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok();
        }
    };


    @GetMapping("/categories")
    @ApiOperation("查看所有的分类/list")
    public Object findGoodsCategoryList(HttpServletRequest request,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer limit)
    {
        List<GoodsCategoryPo> goodsCategoryList=goodsCategoryService.findGoodsCategoryList(page,limit);
        if(goodsCategoryList.size()==0){
            Log log=createLog(request, 0, 0, "查看所有商品分类",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(805,"获取分类列表失败");
        }
        else {
            Log log=createLog(request, 0, 1, "查看所有商品分类",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(goodsCategoryList);
        }
    };

    @PostMapping("/categories")
    @ApiOperation(value="新建一个分类/create")
    public Object addGoodsCategory(HttpServletRequest request,@RequestBody GoodsCategoryPo goodsCategoryPo)
    {
        GoodsCategoryPo retPo=goodsCategoryService.addGoodsCategory(goodsCategoryPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "添加商品分类",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(801,"分类新增失败");
        }
        else {
            Log log=createLog(request, 0, 1, "添加商品分类",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };

    @GetMapping("/categories/{id}")
    @ApiOperation(value="查看单个分类信息/read")
    public Object findGoodsCategoryById(HttpServletRequest request,@PathVariable Integer id)
    {
        GoodsCategoryPo goodsCategoryPo=goodsCategoryService.findGoodsCategoryById(id);
        if(goodsCategoryPo==null)
        {
            Log log=createLog(request, 0, 0, "查看单个商品分类",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(804,"该分类不存在");
        }
        else
        {
            Log log=createLog(request, 0, 1, "查看单个商品分类",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(goodsCategoryPo);
        }
    };


    @PutMapping("/categories/{id}")
    @ApiOperation(value="修改分类信息/update")
    public Object updateGoodsCategory(HttpServletRequest request,
                                      @PathVariable Integer id,
                                      @RequestBody GoodsCategoryPo goodsCategoryPo)
    {
        goodsCategoryPo.setId(id);
        GoodsCategoryPo retPo=goodsCategoryService.updateGoodsCategory(goodsCategoryPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "更新商品分类",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(802,"分类修改失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "更新商品分类",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };


    @DeleteMapping("/categories/{id}")
    @ApiOperation(value="删除单个分类/delete")
    public Object deleteGoodsCategory(HttpServletRequest request,
                                      @PathVariable Integer id)
    {
        int ret=goodsCategoryService.deleteGoodsCategory(id);
        if(ret==0)
        {
            Log log=createLog(request, 0, 0, "删除商品分类",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(803,"分类删除失败​");
        }
        else
        {
            Log log=createLog(request, 0, 1, "删除商品分类",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok();
        }
    };

    @PutMapping("/categories/l2/{id}")
    @ApiOperation(value="更改子分类在父分类下的位置/l2")
    public Object updateGoodsCategoryPid(HttpServletRequest request,
                                         @PathVariable Integer id,
                                         @RequestBody GoodsCategoryPo goodsCategoryPo)
    {
        GoodsCategoryPo destPo=goodsCategoryService.findGoodsCategoryById(id);
        //被修改的分类的PID不能为空，修改后的PID不能为空
        boolean editable=destPo!=null&&destPo.getPid()!=null&&goodsCategoryPo.getPid()!=null;
        if(!editable){
            Log log=createLog(request, 0, 0, "更改子分类在父分类下的位置",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(802,"分类修改失败");
        }
        goodsCategoryPo.setId(id);
        GoodsCategoryPo retPo=goodsCategoryService.updateGoodsCategoryPid(goodsCategoryPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "更改子分类在父分类下的位置",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(802,"分类修改失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "更改子分类在父分类下的位置",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };


    /**
     * 查询商品
     * @param goodsSn
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/admin/goods")
    @ApiOperation(value = "获取商品列表/list", notes = "获取商品列表")
    public Object adminFindGoodsList(HttpServletRequest request,
                                @RequestParam String goodsSn,
                                @RequestParam String name,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer limit)
    {
        List<GoodsPo> goodsList=goodsService.adminFindGoodsList(goodsSn,name,page,limit);
        if(goodsList.size()==0){
            Log log=createLog(request, 0, 0, "获取商品列表",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(776,"获取商品列表失败");
        }
        else {
            Log log=createLog(request, 0, 1, "获取商品列表",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(goodsList);
        }
    };


    /**
     * 编辑商品
     *
     * @param goodsPo
     * @return
     */
    @PutMapping("/goods/{id}")
    @ApiOperation(value = "根据id更新商品信息/update", notes = "根据id更新商品信息")
    public Object updateGoods(HttpServletRequest request,
                              @PathVariable Integer id,
                              @RequestBody GoodsPo goodsPo)
    {
        goodsPo.setId(id);
        GoodsPo retPo=goodsService.updateGoods(goodsPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "更新商品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(772,"商品修改失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "更新商品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @DeleteMapping("/goods/{id}")
    @ApiOperation(value = "根据id删除商品信息/delete", notes = "根据id删除商品信息")
    public Object deleteGoods(HttpServletRequest request,@PathVariable Integer id)
    {
        int ret=goodsService.deleteGoods(id);
        if(ret==0)
        {
            Log log=createLog(request, 0, 0, "删除商品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(773,"商品删除失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "删除商品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok();
        }
    };

    /**
     * 添加商品
     *
     * @param goodsPo
     * @return
     */
    @PostMapping("/goods")
    @ApiOperation(value = "新建/上架一个商品/create", notes = "新建/上架一个商品")
    public Object addGoods(HttpServletRequest request,@RequestBody GoodsPo goodsPo)
    {
        GoodsPo retPo=goodsService.addGoods(goodsPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "添加商品",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(771,"商品新增失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "添加商品",null);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    };

    /**
     * 商品详情
     *
     * @param id
     * @return
     */
    @GetMapping("/admin/goods/{id}")
    @ApiOperation(value = "根据id获取某个商品/detail", notes = "根据id获取某个商品")
    public Object adminFindGoodsById(HttpServletRequest request,@PathVariable Integer id)
    {
        GoodsPo goodsPo=goodsService.adminFindGoodsById(id);
        if(goodsPo==null)
        {
            Log log=createLog(request, 0, 0, "查看单个商品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(775,"该商品不存在​");
        }
        else
        {
            Log log=createLog(request, 0, 1, "查看单个商品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(goodsPo);
        }
    };

    @GetMapping("/goods/{id}/products")
    @ApiOperation(value = "获取商品下的产品列表")
    public Object findProductListByGoodsId(HttpServletRequest request, @PathVariable Integer id)
    {
        List<ProductPo> productList=productService.findProductListByGoodsId(id);
        if(productList.size()==0)
        {
            Log log=createLog(request, 0, 0, "查看商品下的产品列表",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(785,"获取产品列表失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "查看商品下的产品列表",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(productList);
        }
    }

    @PostMapping("/goods/{id}/products")
    @ApiOperation(value = "添加产品到商品")
    public Object addProduct(HttpServletRequest request,
                             @PathVariable Integer id,
                             @RequestBody ProductPo productPo)
    {
        productPo.setGoodsId(id);
        ProductPo retPo=productService.addProduct(productPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "添加产品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(781,"产品新增失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "添加产品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    }

    @PutMapping("/products/{id}")
    @ApiOperation(value = "修改产品信息")
    public Object updateProduct(HttpServletRequest request,
                                @PathVariable Integer id,
                                @RequestBody ProductPo productPo)
    {
        productPo.setId(id);
        ProductPo retPo=productService.updateProduct(productPo);
        if(retPo==null)
        {
            Log log=createLog(request, 0, 0, "更新产品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(782,"产品修改失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "更新产品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok(retPo);
        }
    }

    @DeleteMapping("/products/{id}")
    @ApiOperation(value = "删除产品信息")
    public Object deleteProduct(HttpServletRequest request,@PathVariable Integer id)
    {
        int ret=productService.deleteProduct(id);
        if(ret==0)
        {
            Log log=createLog(request, 0, 0, "删除产品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.fail(783,"产品删除失败");
        }
        else
        {
            Log log=createLog(request, 0, 1, "删除产品",id);
            if(log!=null) { writeLog(log); }
            else { return ResponseUtil.unlogin(); }
            return ResponseUtil.ok();
        }
    }

    //--------------user
    /**
     * 品牌列表
     *
     * @param page 分页页数
     * @param limit 分页大小
     * @return 品牌列表
     */
    @GetMapping("/brands")
    @ApiOperation(value="查看所有品牌 /list")
    public Object userFindBrandList(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer limit)
    {
        List<BrandPo> brandList= brandService.findBrandList(page,limit);
        if(brandList.size()==0){
            return ResponseUtil.fail(795,"获取品牌列表失败");
        }
        return ResponseUtil.ok(brandList);
    };

    @GetMapping("brands/{id}")
    @ApiOperation(value="查看品牌信息")
    public Object userFindBrandById(HttpServletRequest request,@PathVariable Integer id){
        BrandPo brandPo= brandService.findBrandById(id);
        if(brandPo==null){
            return ResponseUtil.fail(794,"该品牌不存在");
        }
        else {
            return ResponseUtil.ok(brandPo);
        }
    };

    @GetMapping("/brands/{id}/goods")
    @ApiOperation(value="获取品牌下的商品")
    public Object findGoodsListByBrandId(@PathVariable Integer id){
        List<GoodsPo> goodsList=goodsService.findGoodsListByBrandId(id);
        if(goodsList.size()==0){
            return ResponseUtil.fail(776,"获取商品列表失败");
        }
        return ResponseUtil.ok(goodsList);
    }

    @GetMapping("/categories/{id}/goods")
    @ApiOperation(value = "获取分类下的商品列表")
    public Object findGoodsListByCategoryId(@PathVariable Integer id){
        List<GoodsPo> goodsList=goodsService.findGoodsListByCategoryId(id);
        if(goodsList.size()==0){
            return ResponseUtil.fail(776,"获取商品列表失败");
        }
        return ResponseUtil.ok(goodsList);
    }


    /**
     * 接口需求已删除
     */
    @GetMapping("/categories/l2")
    @ApiOperation(value = "获取二级种类/getsecondgoodsCategory", notes = "获取二级种类")
    public Object findSecondLevelGoodsCategoryList()
    {
        List<GoodsCategoryPo> goodsCategoryList=goodsCategoryService.findSecondLevelGoodsCategoryList();
        if(goodsCategoryList.size()==0) {
            return ResponseUtil.fail(805,"获取分类列表失败");
        }
        return ResponseUtil.ok(goodsCategoryList);
    };

    /**
     * 内部接口？
     */
    @GetMapping("/categories/l1")
    @ApiOperation(value = "获取一级种类/getOneGoodsCategory", notes = "获取一级种类")
    public Object findFirstLevelGoodsCategoryList()
    {
        List<GoodsCategoryPo> goodsCategoryList=goodsCategoryService.findFirstLevelGoodsCategoryList();
        if(goodsCategoryList.size()==0){
            return ResponseUtil.fail(805,"获取分类列表失败");
        }
        return ResponseUtil.ok(goodsCategoryList);
    };


    /**
     * 当前分类栏目
     *
     * @param id 分类类目ID
     * @return 当前分类栏目
     */
    @GetMapping("categories/l1/{id}/l2")
    @ApiOperation(value = "获取当前一级分类下的二级分类 /current", notes = "获取分类栏目")
    public Object findSecondLevelGoodsCategoryListByPid(@PathVariable Integer id)
    {
        List<GoodsCategoryPo> goodsCategoryList=goodsCategoryService.findSecondLevelGoodsCategoryListByPid(id);
        if(goodsCategoryList.size()==0) {
            return ResponseUtil.fail(805,"获取分类列表失败");
        }
        return ResponseUtil.ok(goodsCategoryList);

    };

    /**
     *
     * @param name 商品名
     * @param page
     * @param limit
     * @return 商品详情
     */
    @GetMapping("/goods")
    @ApiOperation(value = "根据条件搜素商品/list", notes = "根据条件搜素商品")
    public Object userFindGoodsList(@RequestParam String name,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer limit)
    {
        List<GoodsPo> goodsList=goodsService.userFindGoodsList(name,page,limit);
        if(goodsList.size()==0)
        {
            return ResponseUtil.fail(776,"获取商品列表失败");
        }
        return ResponseUtil.ok(goodsList);
    };

    @GetMapping("/goods/{id}")
    @ApiOperation(value = "根据id获取某个商品/detail", notes = "根据id获取某个商品")
    public Object userFindGoodsById(@PathVariable Integer id)
    {
        GoodsPo goodsPo=goodsService.userFindGoodsById(id);
        if(goodsPo==null)
        {
            return ResponseUtil.fail(775,"该商品不存在​");
        }
        return ResponseUtil.ok(goodsPo);
    };

    //----------------内部接口

    @GetMapping("/goods/{id}/isOnSale")
    @ApiOperation(value = "判断商品是否在售")
    public Object beOnSale(@PathVariable Integer id){
        GoodsPo goodsPo=goodsService.userFindGoodsById(id);
        if(goodsPo==null){
            return ResponseUtil.ok(false);
        }
        return ResponseUtil.ok(true);
    }

    @PutMapping("/product/list/deduct")
    @ApiOperation(value = "根据订单物品列表修改库存",notes = "operation：true代表加库存，false代表减库存")
    public Object operateStock(@RequestBody List<OrderItem> orderItemList,@RequestParam boolean operation){
        List<Integer> productIdList=new ArrayList<Integer>();
        List<Integer> numberList=new ArrayList<Integer>();
        for(OrderItem orderItem:orderItemList){
            Integer productId=orderItem.getProductId();
            Integer number=(operation?1:-1)*orderItem.getNumber();
            ProductPo productPo=productService.findProductById(productId);
            boolean operable=productPo!=null&&productPo.getSafetyStock()+number>=0;
            if(!operable){
                return ResponseUtil.fail(786,"修改库存失败");
            }
            productIdList.add(productId);
            numberList.add(number);
        }
        Integer size=orderItemList.size();
        for(int i=0;i<size;i++){
            int ret=productService.updateStock(productIdList.get(i),numberList.get(i));
            if(ret==0){
                return ResponseUtil.fail(786,"修改库存失败");
            }
        }
        return ResponseUtil.ok(true);
    }

//    @GetMapping("/products/{id}")
//    @ApiOperation(value = "根据产品ID返回封装的Product")
//    public Object getProductById2(@PathVariable Integer id){
//        ProductPo productPo=productService.findProductById(id);
//        if(productPo==null){
//            return ResponseUtil.fail(784,"该产品不存在");
//        }
//        Integer goodsId=productPo.getGoodsId();
//        GoodsPo goodsPo=goodsService.adminFindGoodsById(goodsId);
//        Product product=new Product();
//        product.setId(productPo.getId());
//        product.setGoodsId(productPo.getGoodsId());
//        product.setSpecifications(productPo.getSpecifications());
//        product.setSafetyStock(productPo.getSafetyStock());
//        product.setPicUrl(productPo.getPicUrl());
//        product.setPrice(productPo.getPrice());
//        product.setGoodsPo(goodsPo);
//        product.setGmtCreate(productPo.getGmtCreate());
//        product.setGmtModified(productPo.getGmtModified());
//        product.setBeDeleted(productPo.getBeDeleted());
//        return ResponseUtil.ok(product);
//    }

//    @PutMapping("/products/{id}")
//    @ApiOperation(value = "更新Product")
//    public Object updateProductById2(@PathVariable Integer id,@RequestBody Product product){
//        ProductPo productPo=productService.findProductById(id);
//        if(productPo==null){
//            return ResponseUtil.fail(784,"该产品不存在");
//        }
//        product.setId(id);
//        ProductPo retPo=productService.updateProduct(product);
//        if(retPo==null) {
//            return ResponseUtil.fail(782, "产品修改失败");
//        }
//            return ResponseUtil.ok(retPo);
//    }
//
//    //!!!!

    @GetMapping("/user/product/{id}")
    @ApiOperation(value = "根据产品ID返回封装的Product")
    public Object getProductById(@PathVariable Integer id){
        ProductPo productPo=productService.findProductById(id);
        if(productPo==null){
            return ResponseUtil.fail(784,"该产品不存在");
        }
        Integer goodsId=productPo.getGoodsId();
        GoodsPo goodsPo=goodsService.adminFindGoodsById(goodsId);
        Product product=new Product();
        product.setId(productPo.getId());
        product.setGoodsId(productPo.getGoodsId());
        product.setSpecifications(productPo.getSpecifications());
        product.setSafetyStock(productPo.getSafetyStock());
        product.setPicUrl(productPo.getPicUrl());
        product.setPrice(productPo.getPrice());
        product.setGoodsPo(goodsPo);
        product.setGmtCreate(productPo.getGmtCreate());
        product.setGmtModified(productPo.getGmtModified());
        product.setBeDeleted(productPo.getBeDeleted());
        return ResponseUtil.ok(product);
    }






    /**
     * 日志记录函数
     *
     * @param log 日志
     */
    private void writeLog(Log log) {
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance instance = loadBalancerClient.choose("Log");
//        System.out.println(instance.getHost());
//        System.out.println(instance.getPort());
//        String reqURL = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/logs");
//        restTemplate.postForObject(reqURL,log,Log.class);
    }

    /**
     * 生成日志函数
     *
     * @param request
     * @param type
     * @param status
     * @param action
     * @param actionId
     * @return 返回生成的日志或者空值，空值则进行未登录错误处理
     */
    private Log createLog(HttpServletRequest request,Integer type,Integer status,String action,Integer actionId)
    {
//        String adminId= request.getHeader("id");
//        if (adminId==null){
//            return null;
//        }
        Log log=new Log();
//        log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(type);
        log.setActions(action);
        log.setActionId(actionId);
        log.setStatusCode(status);
        return log;
    }

    //----------------测试


    @GetMapping("/test/goods/{id}")
    public GoodsPo findGoodsByIdF(@PathVariable  Integer id){
        GoodsPo goodsPo=goodsService.adminFindGoodsById(id);
        if(goodsPo==null)
        {
            return null;
        }
        else
        {
            return goodsPo;
        }
    }


}