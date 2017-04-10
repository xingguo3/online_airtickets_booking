<%-- 
    Document   : index
    Created on : Mar 20, 2017, 8:26:50 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Welcome to Air Web</h1>
<section id="js-search-controls-container" class="search-controls sc-blue-bg">
        <form action="#" class="clearfix">
                <section id="js-trip-type" class="search-controls-trip-type multi-city-enabled">
                    <div class="mobile-container">
                        <input type="radio" id="js-is-return-input" name="trip-type" value="return" class="visuallyhidden" tabindex="1" />
                        <label for="js-is-return-input" class="return-trip">Return</label>
                        <input type="radio" id="js-one-way-input" name="trip-type" value="oneway" class="visuallyhidden" tabindex="1" />
                        <label for="js-one-way-input" class="one-way-trip">One way</label>
                        <input type="radio" id="js-multi-city-input" name="trip-type" value="multicity" class="visuallyhidden" tabindex="1" />
                        <label for="js-multi-city-input" class="multi-city-trip">Multi-city</label>
                    </div>
                </section>
            <section class="traditional-search clearfix">
                <div id="js-places" class="search-controls-places clearfix">
                    <div class="origin-place">
                        <label for="js-origin-input" class="place-label">From</label>
                        <input type="text" id="js-origin-input" tabindex="2" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" dir="auto">
                        <label class="nearby-alts sc-checkbox">
                            <input type="checkbox" id="js-outbound-alts" class="visuallyhidden" />
                            Add nearby airports
                        </label>
                    </div>
                    <button type="button" id="js-places-toggle" class="swap-button" title="Click here to swap locations">
                        <span class="visuallyhidden">Click here to swap locations</span>
                    </button>
                    <div class="destination-place">
                        <label for="js-destination-input" class="place-label">To</label>
                        <input type="text" id="js-destination-input" placeholder="Enter a country, city or airport" tabindex="2" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" dir="auto">
                        <label class="nearby-alts sc-checkbox">
                            <input type="checkbox" id="js-inbound-alts" class="visuallyhidden" />
                            Add nearby airports
                        </label>
                    </div>
                </div><div id="js-dates" class="search-controls-dates">
                    <div class="depart">
                        <label for="js-depart-input">Depart</label>
                        <input type="text" id="js-depart-input" tabindex="3" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" readonly="">
                    </div>
                    <div class="return ">
                        <label for="js-return-input">Return</label>
                        <input type="text" id="js-return-input" tabindex="3" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" readonly="">
                    </div>
                    <span id="js-depart-summary" class="date-summary"></span>
                    <span id="js-return-summary" class="date-summary"></span>
                </div><div id="js-pax-cabin-class" class="search-controls-pax-cabin-class">
                    <label for="js-trad-cabin-class-travellers-toggle">Cabin Class &amp; Travellers</label>
                    <button type="button" id="js-trad-cabin-class-travellers-toggle" class="cabin-class-travellers-trigger" tabindex="1">
                        <span class="down-arrow">â–¼</span>
                        <span class="adult-icon"></span>
                    </button>
                </div>
                <label class="sc-checkbox prefer-directs">
                    <input type="checkbox" id="js-prefer-directs" class="visuallyhidden" tabindex="1"> Direct flights only
                </label>
                <button class="js-search-button bpk-button bpk-button--large" type="button" tabindex="1">
                    <span class="bpk-text">Search flights&nbsp;</span>
                    <span class="bpk-icon-lg bpk-icon-pointer bpk-icon-lg--align-to-button"></span>
                </button>
            </section>
        </form>
</section>
        <p><a href="./login.jsp">login</a><p/>
        <p>No Account? <a href="./register.jsp">Register</a></p>
    </body>
    
</html>
