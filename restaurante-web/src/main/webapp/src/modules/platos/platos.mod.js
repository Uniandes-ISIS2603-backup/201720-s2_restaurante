/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("platoModule", ['ui.router']);//declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/platos/';
            $urlRouterProvider.otherwise("/platosList");

            /*
             * Vista principal modulo plato
            * Definicion estado abstracto
             */ 
            $stateProvider.state('platos', {
                url: '/platos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'platos.html',
                        controller: 'platosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                /*
                 * Vista de la lista de platos
                 */
            }).state('platosList', {
                url: '/list',
                parent: 'platos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'platos.list.html'
                    }
                }
                /*
                 * Vista del detalle de un plato con un id especificado por parametro
                 * Param: platoId
                 */
            }).state('platosDetail', {
                url: '/{platoId:int}/detail',
                parent: 'platos',
                param: {
                    platoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'platos.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'platos.detail.html',
                        controller: 'platosCtrl',
                        controllerAs: 'ctrl'
                    }

                }
             /*
             * Vista de creacion de un nuevo plato
             */
            }).state('platoCreate', {
                url: '/create',
                parent: 'platos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/platos.new.html',
                        controller: 'platoNewCtrl'
                    }
                }
            })
                    /*
                 * Vista de modificar un plato con un id especificado por parametro
                 * Param: platoId
                 */
                    .state('platoUpdate', {
                        url: '/update/{platoId:int}',
                        parent: 'platos',
                        param: {
                            platoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/platos.new.html',
                                controller: 'platoUpdateCtrl'
                            }
                        }
                    })
                    /*
                    * Vista para eliminar un plato con un id especificado por parametro
                    * Param: platoId
                    */
                    .state('platoDelete', {
                        url: '/delete/{platoId:int}',
                        parent: 'platos',
                        param: {
                            platoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/platos.delete.html',
                                controller: 'platoDeleteCtrl'
                            }
                        }
                    });
        }]);

})(window.angular);