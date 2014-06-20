import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.INFO

appender("FILE", RollingFileAppender) {
  file = "${outgrader.home}/logs/outgrader-proxy.log"
  encoder(PatternLayoutEncoder) {
	pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  }
  rollingPolicy(TimeBasedRollingPolicy) {
	fileNamePattern = "${outgrader.home}/logs/outgrader-proxy-%d{yyyy-MM-dd}.%i.zip"
	timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
	  maxFileSize = "10MB"
	}
  }
}
root(INFO, ["FILE"])