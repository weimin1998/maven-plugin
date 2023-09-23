package com.weimin.plugin;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;

@Mojo(name = "cp", defaultPhase = LifecyclePhase.PACKAGE)
// name指定goal的名字
public class CPMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject mavenProject;

    @Parameter(required = true)
    private String destDir;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Log log = getLog();
        log.info("执行了CPMojo的execute方法!");
        String directory = mavenProject.getBuild().getDirectory();
        String jar = mavenProject.getBuild().getFinalName() + "." + mavenProject.getPackaging();
        String path = directory + File.separator + jar;
        log.info("jar的完整路径：" + path);

        try {
            FileUtils.copyFileToDirectory(new File(path), new File(destDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("jar拷贝完成");
    }
}
