#!/bin/sh
cd ..
cd docker
docker compose --profile infraestrutura -f docker-compose.yml up -d --wait
echo "Os containers estão rodando"
cd ..
cd scripts
