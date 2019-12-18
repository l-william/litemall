package xmu.oomall.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:默认计件模板对象
 * @Data:Created in 14:50 2019/12/11
 **/

@Repository
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class DefaultPieceFreight extends xmu.oomall.domain.DefaultPieceFreightPo {
    private List<Integer> regionIds;
}