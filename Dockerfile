FROM maprtech/pacc:6.1.0_6.0.0_centos7
RUN mkdir -p /usr/share/mapr-apps/
COPY target/my-hello-app.jar /usr/share/mapr-apps/my-hello-app.jar
EXPOSE 8085
CMD [ "java", "-jar", "/usr/share/mapr-apps/my-hello-app.jar" ]