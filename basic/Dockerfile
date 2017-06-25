FROM       nanquanyuhao/tomcat7:demo
MAINTAINER liyh <liyh1928@chinaunicom.cn>

ADD init /init
RUN chmod +x /init

RUN rm ${APP_DIR}/init

ENTRYPOINT ["/init", "/scripts/run"]
