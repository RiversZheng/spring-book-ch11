# Docker化应用的构建

## 应用构建要求
- 若使用脚本通过主机登陆直接启动镜像进行测试，可通过以下脚本进行，最后访问宿主机IP即可
```
docker build -t nanquanyuhao/basic .
docker run -d --name basic -p 80:8080 nanquanyuhao/basic
```
- 以下为jenkins构建临时shell脚本配置
```
echo 'test project basic'

cp -pr $WORKSPACE/basic $WORKSPACE/maven/
sudo docker build -t nanquanyuhao/maven:demo $WORKSPACE/maven

if sudo docker ps -a | grep -i maven ; then
	sudo docker rm -vf maven
fi
sudo docker create --name maven nanquanyuhao/maven:demo
sudo docker cp maven:/basic/target/basic.war $WORKSPACE/basic/
sudo docker build -t nanquanyuhao/basic $WORKSPACE/basic

if sudo docker ps -a | grep -i basic ; then
	sudo docker rm -vf basic
fi
docker run -d --name basic -p 80:8080 nanquanyuhao/basic

echo 'test project basic'
```