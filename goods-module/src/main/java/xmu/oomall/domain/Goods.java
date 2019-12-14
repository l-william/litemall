package xmu.oomall.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xmu.oomall.domain.BrandPo;

import java.util.List;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:商品对象
 * @Data:Created in 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Goods extends xmu.oomall.domain.GoodsPo {
    @Setter
    @Getter
    private BrandPo brandPo;
    private xmu.oomall.domain.GoodsCategoryPo goodsCategoryPo;
    private List<ProductPo> productPoList;
    private GrouponRule grouponRule;
    private ShareRule shareRule;
    private PresaleRule presaleRule;
}
