kubectl delete -f ./secret-admin.yaml --namespace=grupo-08-dev
kubectl delete -f ./configmap-admin.yaml --namespace=grupo-08-dev
kubectl delete -f ./deployment-admin.yaml --namespace=grupo-08-dev
kubectl delete -f ./hpa-admin.yaml --namespace=grupo-08-dev
kubectl delete -f ./loadbalancer-admin.yaml --namespace=grupo-08-dev
kubectl delete -f ./clusterip-admin.yaml --namespace=grupo-08-dev