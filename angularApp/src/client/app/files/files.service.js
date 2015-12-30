(function() {
    'use strict';

    angular
        .module('app.files')
        .factory('FilesService', FilesService);

    /* @ngInject */
    function FilesService($http, ENDPOINTS) {


        var endpoint = ENDPOINTS.host +'files/';

        return {
            find: find,
            save: save,
            discard: discard,
            reset: reset
        };

        function find(status) {

            var uri = endpoint;
            if (status) {
                uri += '?status=' + status;
            }

            return $http.get(uri)
                .then(function(response) {
                    return response.data;
                });
        }

        function save(item) {
            item.status = '...';
            return $http.put(endpoint + item.id, {
                status: 'DOWNLOAD'
            });
        }

        function discard(item) {
            item.status = '...';
            return $http.put(endpoint + item.id, {
                status: 'DISCARDED'
            });
        }

        function reset(item) {
            item.status = '...';
            return $http.put(endpoint + item.id, {
                status: 'PENDING'
            });
        }
    }
})();
