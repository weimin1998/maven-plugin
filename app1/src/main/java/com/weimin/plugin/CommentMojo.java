package com.weimin.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

/**
 * @goal comment
 */
public class CommentMojo extends AbstractMojo {
    // Mojo: maven old java object, 每一个mojo类都是maven plugin的一个执行目标goal
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Log log = getLog();
        log.info("执行了CommentMojo的execute方法!");
    }
}
