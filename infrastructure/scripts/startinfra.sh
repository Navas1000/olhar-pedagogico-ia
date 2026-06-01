#!/bin/sh
cd ..
cd docker
docker compose -f docker-compose.yml up -d --wait --profile infraestrutura
echo "Os containers estão rodando"
cd ..
cd scripts
