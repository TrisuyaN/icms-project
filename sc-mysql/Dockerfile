FROM mysql:8.0.37

ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=sc

COPY init.sql /docker-entrypoint-initdb.d/
COPY my.cnf /etc/mysql/my.cnf

EXPOSE 3306
