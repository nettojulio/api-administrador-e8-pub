kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8/secret-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8/configmap-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8/deployment-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8/hpa-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8/loadbalancer-admin.yaml --namespace=grupo-08-dev
kubectl apply -f /home/ubuntu/grupo08/api-administrador-e8/clusterip-admin.yaml --namespace=grupo-08-dev