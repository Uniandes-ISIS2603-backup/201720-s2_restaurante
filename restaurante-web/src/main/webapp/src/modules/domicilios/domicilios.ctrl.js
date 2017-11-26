(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domicilioCtrl', ['$scope', '$http', 'domiciliosContext','$state',
        function ($scope, $http, domiciliosContext, $state) {
            $http.get(domiciliosContext).then(function (response) {
                $scope.domiciliosRecords = response.data;
            });
            $http.get("http://localhost:8080/restaurante-web/api/platos").then(function (response) {
                $scope.platosRecords = response.data;
            });
            if (($state.params.domicilioId !== undefined) && ($state.params.domicilioId !== null)) {
                $http.get(domiciliosContext + '/' + $state.params.domicilioId).then(function (response) {
                    $scope.currentDomicilio = response.data;
                });
            }
            if (($state.params.domicilioId !== undefined) && ($state.params.domicilioId !== null)) {
                $http.get("http://localhost:8080/restaurante-web/api/pedidos" + '/' + $state.params.domicilioId).then(function (response) {
                    $scope.currentPedido = response.data;
                });
            }
        }
    ]);
}
)(angular);