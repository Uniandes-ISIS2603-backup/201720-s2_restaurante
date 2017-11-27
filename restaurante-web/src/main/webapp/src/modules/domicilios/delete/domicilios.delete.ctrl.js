/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("domicilioModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domicilioDeleteCtrl', ['$scope', '$http', 'domiciliosContext', '$state',
        /*
         * Eliminamos un domicilio con id especificado por parametro
         * Param: domicilioId
         */
        function ($scope, $http, domiciliosContext, $state) {
            var idDomicilio = $state.params.domicilioId;
            $scope.deleteDomicilio = function () {
                $http.delete(domiciliosContext + '/' + idDomicilio, {}).then(function (response) {
                    $state.go('domiciliosList', {domicilioId: response.data.id}, {reload: true});
                    var index = $scope.domiciliosRecords.indexOf(response.data); //actualizamos los records de la vista
                    $scope.domiciliosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);