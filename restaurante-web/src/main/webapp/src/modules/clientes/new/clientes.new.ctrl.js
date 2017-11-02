/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteNewCtrl', ['$scope', '$http', 'clientesContext', '$state', 'pedidosContext', '$rootScope',
        function ($scope, $http, clientesContext, $state, pedidosContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createCliente = function () {
                $http.post(clientesContext, {
                    name: $scope.clienteName,
                    birthDate: $scope.clienteBirthDate,
                    description: $scope.clienteDescription,
                    image: $scope.clienteImage
                }).then(function (response) {
                    //Cliente created successfully
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

