#!/bin/bash

# Variáveis de configuração
SERVICE_NAME="bmt-cadastro-de-pessoas"
DOCKER_NETWORK="BMT-rede-docker"

# Passo 1: Obter a versão do pom.xml usando Maven
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

# Passo 2: Parar o container atual
echo "Parando o container $SERVICE_NAME..."
docker stop $SERVICE_NAME

# Passo 3: Remover o container atual
echo "Removendo o container $SERVICE_NAME..."
docker rm $SERVICE_NAME

# Passo 4: Remover a imagem antiga
echo "Removendo a imagem antiga $SERVICE_NAME..."
docker rmi $SERVICE_NAME:$VERSION

# Passo 5: Construir a nova imagem com a versão do pom.xml
echo "Construindo a nova imagem $SERVICE_NAME:$VERSION..."
docker build -t $SERVICE_NAME:$VERSION .

# Passo 6: Rodar o novo container com a nova imagem
#echo "Criando e iniciando o container $SERVICE_NAME..."
#docker run -d --name $SERVICE_NAME -p 9090:9090 --network $DOCKER_NETWORK $SERVICE_NAME:$VERSION

## Passo 7: Verificar se o container está rodando
#echo "Verificando se o container está rodando..."
#docker ps | grep $SERVICE_NAME

echo "Deploy concluído com sucesso!"
