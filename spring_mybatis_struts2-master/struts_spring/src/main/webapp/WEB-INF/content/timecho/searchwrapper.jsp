<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
                <div class="search-area-wrapper">
                        <div class="search-area container">
                                <!-- <h3 class="search-header">Have a Question?</h3> -->
                                <p class="search-tag-line">If you have any question you can ask below or enter what you are looking for!</p>

                                <form id="search-form" class="search-form clearfix" method="post" action="searcha" autocomplete="off">
                                        <input class="search-term required" type="text" id="s" name="s" placeholder="输入搜索信息" title="* 请输入搜索信息!" />
                                        <input class="search-btn" type="submit" value="搜索" />
                                        <div id="search-error-container"></div>
                                </form>
                        </div>
                </div>