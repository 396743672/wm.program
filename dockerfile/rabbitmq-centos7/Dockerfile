FROM       base-contos:7
MAINTAINER po.lu,Lupo<lupo.f@outlook.com>

# erlang 
RUN yum install -y erlang 
# add
COPY rabbitmq-server-3.6.14-1.el6.noarch.rpm /rabbitmq-server-3.6.14-1.el6.noarch.rpm
# install 
RUN yum install -y rabbitmq-server-3.6.14-1.el6.noarch.rpm
# START RABBITMQ
#RUN rabbitmq-server -detached

# config rabbitmq
#RUN rabbitmq-plugins enable rabbitmq-management \ 
#	rabbitmqctl add_user admin 123456 \ 
#	rabbitmqctl set_user_tags admin administrator \ 
#	rabbitmqctl set_permissions -p "/" admin ".*" ".*" ".*"
#
EXPOSE 5672 15672

CMD ["/bin/bash"]


