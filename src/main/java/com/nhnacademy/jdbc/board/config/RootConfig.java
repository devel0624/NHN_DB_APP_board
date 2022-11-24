package com.nhnacademy.jdbc.board.config;
import com.nhnacademy.jdbc.board.Base;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)
                ,@ComponentScan.Filter(Mapper.class)
})
public class RootConfig {

}
