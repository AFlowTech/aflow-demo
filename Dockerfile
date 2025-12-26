FROM registry-aflow-registry.cn-hangzhou.cr.aliyuncs.com/public/eclipse-temurin:8-jdk-jammy
VOLUME /tmp

ARG DEPENDENCY=target/dependency

COPY ${DEPENDENCY}/WEB-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/WEB-INF/classes /app

ENTRYPOINT exec java $JVM_OPTS -cp app:app/lib/* com.ai.demo.DemoApplication