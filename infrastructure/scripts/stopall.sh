#!/bin/sh
cd ..
cd docker
docker compose --profile infraestrutura --profile aplicacao down
echo "Todos os containers foram parados"
cd ..
cd scripts
