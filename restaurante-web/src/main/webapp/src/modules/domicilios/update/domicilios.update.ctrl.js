(
        function (ng) {
            var mod = ng.module("domicilioModule");
            mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
            mod.controller('domicilioUpdateCtrl', ['$scope', '$http', 'domiciliosContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, domiciliosContext, $state, domiciliosContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idDomicilio = $state.params.domicilioId;

                    $http.get(domiciliosContext + '/' + idDomicilio).then(function (response) {
                        var domicilio = response.data;
                    });
                    
                    $scope.createDomicilio = function () {
                        $http.put(domiciliosContext + "/" + idDomicilio, {
                        });
                    };
                }
            ]);
        }
)(angular);