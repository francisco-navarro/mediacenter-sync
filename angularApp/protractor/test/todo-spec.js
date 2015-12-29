describe('angularjs homepage todo list', function() {
  xit('should add a todo', function() {

  	

    browser.get('http://localhost/');   

    var countC = 0;
    while (countC < 1) {
      element.all(by.tagName('accordion')).count().then(function(count) {
        countC = count;
      });
    }

    expect(countC).toBe(1);


    var button = element(by.css('div.ng-scope > button')[0]);
    button.click();


  });
});
