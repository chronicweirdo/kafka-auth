FROM ubuntu

RUN apt-get update
RUN apt-get install -y nginx
RUN apt-get install -y nginx-extras

#RUN apt-get install -y dpkg-dev
#RUN add-apt-repository ppa:nginx/stable
#RUN echo "deb http://ppa.launchpad.net/nginx/stable/ubuntu lucid main" >> /etc/apt/sources.list.d/nginx-stable-lucid.list
#RUN echo "deb-src http://ppa.launchpad.net/nginx/stable/ubuntu lucid main" >> /etc/apt/sources.list.d/nginx-stable-lucid.list
#RUN apt-get update
#RUN apt-get build-dep nginx

# load_module /usr/lib/nginx/modules/ngx_stream_module.so;


#COPY conf /etc/nginx/conf.d
COPY conf/nginx.conf /etc/nginx/nginx.conf


CMD ["nginx", "-g", "daemon off;"]

#apt-get install libpcre3 libpcre3-dev
#apt-get install zlib1g-dev
#apt-get install libxml2
#apt-get install libxml2-dev
#apt-get install libxslt libxslt-dev
#apt-get install php-gd
#apt-get install libgd-dev
#apt install libgeoip1 libgeoip-dev geoip-bin

#https://www.howtoforge.com/tutorial/how-to-build-nginx-from-source-on-ubuntu-1804-lts/



#./configure --prefix=/etc/nginx --sbin-path=/usr/sbin/nginx --modules-path=/usr/lib/nginx/modules --conf-path=/etc/nginx/nginx.conf --error-log-path=/var/log/nginx/error.log --pid-path=/var/run/nginx.pid --lock-path=/var/run/nginx.lock --user=nginx --group=nginx --build=Ubuntu --builddir=nginx-1.15.0 --with-select_module --with-poll_module --with-threads --with-file-aio --with-http_ssl_module --with-http_v2_module --with-http_realip_module --with-http_addition_module --with-http_xslt_module=dynamic --with-http_image_filter_module=dynamic --with-http_geoip_module=dynamic --with-http_sub_module --with-http_dav_module --with-http_flv_module --with-http_mp4_module --with-http_gunzip_module --with-http_gzip_static_module --with-http_auth_request_module --with-http_random_index_module --with-http_secure_link_module --with-http_degradation_module --with-http_slice_module --with-http_stub_status_module --with-http_perl_module=dynamic --with-perl_modules_path=/usr/share/perl/5.26.1 --with-perl=/usr/bin/perl --http-log-path=/var/log/nginx/access.log --http-client-body-temp-path=/var/cache/nginx/client_temp --http-proxy-temp-path=/var/cache/nginx/proxy_temp --http-fastcgi-temp-path=/var/cache/nginx/fastcgi_temp --http-uwsgi-temp-path=/var/cache/nginx/uwsgi_temp --http-scgi-temp-path=/var/cache/nginx/scgi_temp --with-mail=dynamic --with-mail_ssl_module --with-stream=dynamic --with-stream_ssl_module --with-stream_realip_module --with-stream_geoip_module=dynamic --with-stream_ssl_preread_module --with-compat --with-pcre=../pcre-8.42 --with-pcre-jit --with-zlib=../zlib-1.2.11 --with-openssl=../openssl-1.1.0h --with-openssl-opt=no-nextprotoneg --with-debug

#auto/configure --with-stream=dynamic