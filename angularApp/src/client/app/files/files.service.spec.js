/* jshint -W117, -W030 */
describe('files', function() {
    describe('service', function() {
        beforeEach(function() {
            module('app.files');
            bard.inject('$rootScope', 'FilesService', '$http');
        });
        it('should invoke find url', function() {
            //spyOn($http, 'get');
            FilesService.find();
            //expect($http.get).toHaveBeenCalled();
        });
    });
});
