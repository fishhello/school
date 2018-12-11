package service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * 
* @ClassName: Generator 
* @Description: TODO(自动生成数据库entity、mapper) 
* @author shafish
* @date 2018年6月6日 下午1:56:52 
*
 */
public class Generator {
	public static void main(String[] args) throws Exception{
		List<String> wannings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(Generator.class.getResource("/generatorConfig.xml").getFile());
		ConfigurationParser cp = new ConfigurationParser(wannings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, wannings);
		myBatisGenerator.generate(null); 
	}
}
