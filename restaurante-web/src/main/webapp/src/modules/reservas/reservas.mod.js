(function (ng){
    var mod = ng.module("reservaModule",['ui.router']);//declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider){
            var basePath='src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");
            
            /*
             * Vista principal modulo reserva
             * Definicion estado abstracto
             */  
            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.html',
                        controller: 'reservasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                /*
                 * Vista de la lista de reservas
                 */
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
                /*
                 * Vista del detalle de un reserva con un id especificado por parametro
                 * Param: reservaId
                 */
            }).state('reservaDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservasCtrl',
                        controllerAs: 'ctrl'
                    }

                }
             /*
             * Vista de creacion de una nueva reserva
             */
            }).state('reservasCreate', {
                url: '/create',
                parent: 'reservas',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/reservas.new.html',
                        controller: 'reservaNewCtrl'
                    }
                }
                
                /*
                 * Vista de modificar una reserva con un id especificado por parametro
                 * Param: reservaId
                 */
            }).state('reservaUpdate', {
                url: '/update/{reservaId:int}',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/reservas.new.html',
                        controller: 'reservaUpdateCtrl'
                    }
                }
            })
                 /*
                 * Vista para eliminar una reserva con un id especificado por parametro
                 * Param: reservaId
                 */
                    .state('reservaDelete', {
                url: '/delete/{reservaId:int}',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                       templateUrl: basePath + '/delete/reserva.delete.html',
                        controller: 'reservaDeleteCtrl'
                    }
                }
            })
            ;
    }]);
})(window.angular);