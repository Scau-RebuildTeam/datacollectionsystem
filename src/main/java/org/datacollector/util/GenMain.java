package org.datacollector.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.21.
 */
public class GenMain {

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        String config = "/mybatis-generator.xml";
        File configFile = new File(GenMain.class.getResource(config).getFile());
        ConfigurationParser parser = new ConfigurationParser(warnings);
        Configuration configuration = null;
        try {
            configuration = parser.parseConfiguration(configFile);
        } catch (XMLParserException | IOException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = null;
        try {
            assert configuration != null;
            myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            assert myBatisGenerator != null;
            myBatisGenerator.generate(null);
        } catch (SQLException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
