FROM    clojure:lein
RUN     mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY    project.clj /usr/src/app/
# Install prerequisites
RUN apt-get update && apt-get install -y \
curl
# RUN     lein deps
COPY    . /usr/src/app
RUN     mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar

EXPOSE  5000

CMD java -jar app-standalone.jar
