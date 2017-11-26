(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
    mod.controller('domicilioNewCtrl', ['$scope', '$http', 'domiciliosContext', '$state', '$rootScope',
        function ($scope, $http, domiciliosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createDomicilio = function () {
                $http.post("http://localhost:8080/restaurante-web/api/pedidos", {
                    direccion: $scope.direccion,
                    id: -1,
                    name: $scope.nombre
                });
                $http.post(domiciliosContext, {
                    id: -1,
                    platos: $scope.platos,
                    rango: $scope.rango
                }).then(function (response) {
                    $state.go('domiciliosList', {domicilioId: response.data.id}, {reload: true});
                    var index = $scope.domiciliosRecords.indexOf(response.data);
                    $scope.domiciliosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);