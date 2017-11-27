(function (ng) {
var mod = ng.module("domicilioModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domiciliosList");
         /*
         * Vista principal modulo domicilio
         * Definicion estado abstracto
         */   
        $stateProvider.state('domicilios', {
                url: '/domicilios',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'domicilios.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                /*
                 * Vista de la lista de domicilio
                 */
            }).state('domiciliosList', {
                url: '/list',
                parent: 'domicilios',
                views: {
                    'listView': {
                        templateUrl: basePath + 'domicilios.list.html'
                    }
                }
                 /*
                 * Vista del detalle de un domicilio con un id especificado por parametro
                 * Param: domicilioId
                 */
            }).state('domicilioDetail', {
                url: '/{domicilioId:int}/detail',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'domicilios.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'domicilios.detail.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }

                }
             /*
             * Vista de creacion de un nuevo domicilio
             */
            }).state('domiciliosCreate', {
                url: '/create',
                parent: 'domicilios',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/domicilios.new.html',
                        controller: 'domicilioNewCtrl'
                    }
                }
                /*
                 * Vista de modificar un domicilio con un id especificado por parametro
                 * Param: domicilioId
                 */
            }).state('domicilioUpdate', {
                url: '/update/{domicilioId:int}',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/domicilios.new.html',
                        controller: 'domicilioUpdateCtrl'
                    }
                }
                /*
                 * Vista para eliminar un domicilio con un id especificado por parametro
                 * Param: domicilioId
                 */
            }).state('domicilioDelete', {
                url: '/delete/{domicilioId:int}',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/domicilios.delete.html',
                        controller: 'domicilioDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);