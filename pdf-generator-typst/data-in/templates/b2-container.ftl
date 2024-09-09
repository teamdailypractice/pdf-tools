<#macro container>
    <div class="container">
        <div class="row row-content">
<@username.userName/>
            <div class="col-sm-12">
                <div id="main" style="visibility: hidden;">
<@tablist.tablist/>
<@tabContent.b3TabContent/>
                </div>
            </div>
        </div>
    </div>
</#macro>