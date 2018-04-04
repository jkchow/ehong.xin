<#include "/default/utils/ui.ftl"/>

<@layout "关于我们">

<div class="row main">
    <div class="col-xs-12 col-md-9 side-left topics-show">
        <!-- view show -->
        <div class="topic panel panel-default">
            <div class="infos panel-heading">

                <h1 class="panel-title topic-title">关于本站</h1>

                <#--<div class="meta inline-block">
                    <a class="author" href="#"></a>
                </div>-->
                <div class="clearfix"></div>
            </div>

            <div class="content-body entry-content panel-body ">
                <div class="markdown-body" id="emojify">
                    <p><strong>关于一泓</strong><br/></p>
                    <p>zhouyihong.cn(中文名:一泓清水)是一个以内容为主的博客分享平台。</p>
                    <p><strong>来源</strong><br/></p>
                    <p>先说域名吧，在我读初中的时候，学到论语，曾子曰：“士不可以不弘毅，任重而道远。仁以为己任，不亦重乎？死而后已，不亦远乎？”
                        子曰：“岁寒，然后知松柏之后凋也。”。当时就想改个名字叫周弘毅，哈哈，很是中二吧，感觉改名字还挺麻烦的，就一直没改，后来想想
                        把这个名字留给子女的，就想拿名字注册个域名，结果发现已经被占有的，想想还和360老大撞车了，对一泓清水也是情有独钟，干脆就注册了zhouyihong.cn。
                        一直想着做个博客网站，就用以前保存的一个很好地框架改吧改吧就部署
                        了。现在终于上线1.0版，欢迎您的访问，你可以在这里注册发表文章，以后我会多多优化持续改进更新，希望这个网站能像他的名字一个
                        永远保持下去。
                    </p>

				</div>
            </div>
            <div class="panel-footer operate">
            </div>
            <div class="panel-footer operate">
                <div class="hidden-xs">
                    <div class="social-share" data-sites="weibo, wechat, facebook, twitter, google, qzone, qq"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- /view show -->
    </div>
    <div class="col-xs-12 col-md-3 side-right hidden-xs hidden-sm">
		<#include "/default/inc/right.ftl"/>
    </div>
</div>

</@layout>