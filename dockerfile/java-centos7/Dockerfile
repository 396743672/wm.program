FROM       weiming/base-centos:latest
MAINTAINER po.lu,Lupo<lupo.f@outlook.com>

# copy jdk.tar.gz
ADD jdk-8u151-linux-x64.tar.gz /usr/local/

ENV JAVA_HOME=/usr/local/jdk1.8.0_151
ENV CLASSPATH=$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar PATH=$PATH:$JAVA_HOME/bin

RUN echo JAVA_HOME=/usr/local/jdk1.8.0_151\nCLASSPATH=$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar PATH=$PATH:$JAVA_HOME/bin\nPATH=$PATH:$HOME/.local/bin:$HOME/bin:$JAVA_HOME/bin\nexport JAVA_HOME CLASS_PATH PATH >> /etc/profile

CMD ["/bin/bash"]
