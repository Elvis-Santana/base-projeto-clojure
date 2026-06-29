FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y curl && \
    curl -O https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && \
    chmod +x lein && \
    mv lein /usr/local/bin/

USER jenkins