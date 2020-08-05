package demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author TuTu
 * @date 2020/6/16 20:21
 */
public class ClassDemo {

    @Test
    public void run() {
        AutoGenerator autoGenerator = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir("F:\\education2.0\\service\\service-order\\src\\main\\java");

        globalConfig.setAuthor("Tutu"); //作者
        globalConfig.setOpen(false); //生成文件是否打开
        globalConfig.setFileOverride(false); //覆盖
        globalConfig.setIdType(IdType.ID_WORKER); //ID_WORKER_STR
        globalConfig.setDateType(DateType.TIME_PACK);
        globalConfig.setSwagger2(true); //开启swagger2
        autoGenerator.setGlobalConfig(globalConfig);

        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/education_course?serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("tcr.order"); //模块名
        packageConfig.setParent("cn"); //包名
        packageConfig.setController("controller");
        packageConfig.setEntity("bean");
        packageConfig.setService("service");
        packageConfig.setMapper("mapper");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();

        strategyConfig.setInclude("order_info");

        strategyConfig.setNaming(NamingStrategy.underline_to_camel); //数据库表命名到实体类的命名策略
        strategyConfig.setTablePrefix(packageConfig.getModuleName()+ "_"); //生成实体时去掉表前缀

        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略
        strategyConfig.setEntityLombokModel(true);

        strategyConfig.setRestControllerStyle(true); //result api风格控制器
        strategyConfig.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }


}
