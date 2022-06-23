kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8-deploy/secret-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8-deploy/configmap-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8-deploy/loadbalancer-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8-deploy/clusterip-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8-deploy/deployment-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8-deploy/hpa-admin.yaml --namespace=grupo-08-dev
