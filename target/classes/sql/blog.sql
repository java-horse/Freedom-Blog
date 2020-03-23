/*
 Navicat Premium Data Transfer

 Source Server         : Navicat-MySQL
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 22/03/2020 22:27:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `appreciation` int(11) NOT NULL DEFAULT 0,
  `share_statement` int(11) NOT NULL DEFAULT 0,
  `releaseComment` int(11) NOT NULL DEFAULT 0,
  `published` int(11) NOT NULL DEFAULT 0,
  `recommend` int(11) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `tag_ids` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (5, '玩转RebbitMQ消息队列', '                    [TOC]\r\n            #### Disabled options\r\n            - TeX (Based on KaTeX);\r\n            - Emoji;\r\n            - Task lists;\r\n            - HTML tags decode;\r\n            - Flowchart and Sequence Diagram;\r\n                ', 'https://i.picsum.photos/id/866/800/450.jpg', '原创', 257, 0, 0, 1, 1, 1, '2019-02-20 08:26:59', '2019-02-21 12:57:05', 4, 2, 'RabbitMQ 是一个由 Erlang 语言开发的 AMQP 的开源实现。AMQP ：Advanced Message Queue，高级消息队列协议。它是应用层协议的一个开放标准，为面向消息的中间件设计，基于此协议的客户端与消息中间件可传递消息，并不受产品、开发语言等条件的限制。RabbitMQ 最初起源于金融系统，用于在分布式系统中存储转发消息，在易用性、扩展性、高可用性等方面表现不俗', '15,16');
INSERT INTO `t_blog` VALUES (6, 'Mybatis原来如此神奇', '# [TOC]                    [TOC]\r\n            #### disabled options\r\n            - tex (based on katex);\r\n            - emoji;\r\n            - task lists;\r\n            - html tags decode2020-\r\n            - flowchart and sequence 		Diagram;\r\n		\r\n		2020-02-23 13:38:33 星期日\r\n', 'https://i.picsum.photos/id/865/800/450.jpg', '原创', 495, 0, 0, 1, 1, 1, '2020-02-20 10:22:43', '2020-02-23 05:39:04', 12, 2, 'MyBatis 是支持普通 SQL 查询,存储过程和高级映射的优秀持久层框架。MyBatis 消除 了几乎所有的 JDBC 代码和参数的手工设置以及结果集的检索。MyBatis 使用简单的 XML 或注解用于配置和原始映射,将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java 对象)映射成数据库中的记录', '14');
INSERT INTO `t_blog` VALUES (7, 'swagger UI前后端分离', '### 前言\r\n\r\nSwagger :tw-1f1e8-1f1f3: 是一款RESTFUL接口的文档在线自动生成+功能测试功能软件。本文简单介绍了在项目中集成swagger的方法和一些常见问题。如果想深入分析项目源码，了解更多内容，见参考资料。\r\n\r\nSwagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。总体目标是使客户端和文件系统作为服务器以同样的速度来更新。文件的方法，参数和模型紧密集成到服务器端的代码，允许API来始终保持同步。Swagger 让部署管理和使用功能强大的API从未如此简单。\r\n\r\n一、使用介绍\r\n什么是 Swagger?\r\nSwagger™的目标是为REST APIs 定义一个标准的，与语言无关的接口，使人和计算机在看不到源码或者看不到文档或者不能通过网络流量检测的情况下能发现和理解各种服务的功能。当服务通过Swagger定义，消费者就能与远程的服务互动通过少量的实现逻辑。类似于低级编程接口，Swagger去掉了调用服务时的很多猜测。\r\n浏览 Swagger-Spec 去了解更多关于Swagger 项目的信息，包括附加的支持其他语言的库。\r\n如何集成Swagger-springmvc到我们的项目中?\r\n依赖：\r\nMaven\r\n<dependency>\r\n<groupId>com.mangofactory</groupId>\r\n<artifactId>swagger-springmvc</artifactId>\r\n<version>0.9.4</version>\r\n</dependency>\r\nGradle\r\n\r\nrepositories {\r\njcenter()\r\n}\r\n \r\ncompile \"com.mangofactory:swagger-springmvc:0.9.4\"\r\n使用：\r\n要最快捷地启动swagger-springmvc项目并且使用默认设置，推荐的方式是使用SwaggerSpringMvc插件\r\n\r\nSpring Java Configuration\r\n@Configuration\r\n@EnableWebMvc\r\n@EnableSwagger\r\n@ComponentScan(\"com.myapp.packages\")\r\npublic class WebAppConfig {\r\n ...\r\n}\r\nSpring xml Configuration\r\n<mvc:annotation-driven/> <!-- Required so swagger-springmvc can access spring\'s RequestMappingHandlerMapping  -->\r\n<bean class=\"com.mangofactory.swagger.configuration.SpringSwaggerConfig\" />\r\nSwaggerSpringMvcPlugin XML Configuration\r\n为了使用这个插件，你需要创造一个spring java配置类。使用spring的 @Configuration ，这个配置类必须被定义到你的xml上下文\r\n\r\n<!-- Required so swagger-springmvc can access spring\'s RequestMappingHandlerMapping  -->\r\n<mvc:annotation-driven/>\r\n \r\n\r\n<bean class=\"com.yourapp.configuration.MySwaggerConfig\"/>\r\n@Configuration\r\n@EnableSwagger //Loads the spring beans required by the framework\r\npublic class MySwaggerConfig {\r\n \r\nprivate SpringSwaggerConfig springSwaggerConfig;\r\n \r\n/**\r\n* Required to autowire SpringSwaggerConfig\r\n*/\r\n@Autowired\r\npublic void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {\r\n  this.springSwaggerConfig = springSwaggerConfig;\r\n}\r\n \r\n/**\r\n* Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple\r\n* swagger groups i.e. same code base multiple swagger resource listings.\r\n */\r\n@Bean\r\npublic SwaggerSpringMvcPlugin customImplementation(){\r\n  return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)\r\n          .includePatterns(\".*pet.*\");\r\n}\r\n \r\n}\r\nSwaggerSpringMvcPlugin Spring Java Configuration\r\n使用@EnableSwagger注解 \r\n自动注入SpringSwaggerConfig \r\n定义一个或多个SwaggerSpringMvcPlugin实例，通过springs @Bean注解\r\n\r\n@Configuration\r\n@EnableWebMvc\r\n@EnableSwagger\r\n@ComponentScan(\"com.myapp.controllers\")\r\npublic class CustomJavaPluginConfig {\r\n \r\nprivate SpringSwaggerConfig springSwaggerConfig;\r\n \r\n@Autowired\r\npublic void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {\r\n  this.springSwaggerConfig = springSwaggerConfig;\r\n}\r\n \r\n@Bean //Don\'t forget the @Bean annotation\r\npublic SwaggerSpringMvcPlugin customImplementation(){\r\n  return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)\r\n        .apiInfo(apiInfo())\r\n        .includePatterns(\".*pet.*\");\r\n}\r\n \r\nprivate ApiInfo apiInfo() {\r\n  ApiInfo apiInfo = new ApiInfo(\r\n          \"My Apps API Title\",\r\n          \"My Apps API Description\",\r\n          \"My Apps API terms of service\",\r\n          \"My Apps API Contact Email\",\r\n          \"My Apps API Licence Type\",\r\n          \"My Apps API License URL\"\r\n    );\r\n  return apiInfo;\r\n}\r\n}\r\n二、碰到的问题\r\n关于@API注解\r\n在Swagger Annotation中： \r\n\r\n \r\n\r\nAPI表示一个开放的API，可以通过description简要描述该API的功能。 \r\n在一个@API下，可有多个@ApiOperation，表示针对该API的CRUD操作。在ApiOperation Annotation中可以通过value，notes描述该操作的作用，response描述正常情况下该请求的返回对象类型。 \r\n在一个ApiOperation下，可以通过ApiResponses描述该API操作可能出现的异常情况。 \r\n\r\n \r\n\r\nApiParam用于描述该API操作接受的参数类型\r\n\r\n \r\n\r\n再接着，为项目的Model对象添加Swagger Annotation，这样Swagger Scanner可以获取更多关于Model对象的信息。\r\n\r\n@ApiModel(value = \"A SayingRepresentation is a representation of greeting\")\r\n@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)\r\npublic class SayingRepresentation {\r\nprivate long id;\r\n@ApiModelProperty(value = \"greeting content\", required = true)\r\nprivate String content;\r\n \r\npublic SayingRepresentation(long id, String content) {\r\n    this.id = id;\r\n    this.content = content;\r\n}\r\n \r\npublic long getId() {\r\n    return id;\r\n}\r\n \r\npublic String getContent() {\r\n    return content;\r\n}\r\n通过上面的步骤，项目已经具备了提供Swagger格式的API信息的能力，接下来，我们把这些信息和Swagger UI集成，以非常美观，实用的方式把这些API信息展示出来。\r\n\r\n和Swagger UI的集成\r\n首先，从github(https://github.com/wordnik/swagger-ui)上下载Swagger-UI, 把该项目dist目录下的内容拷贝到项目的resources的目录assets下。\r\n\r\n\r\n\r\n然后，修改index.html, 把Swagger UI对象中的URL替换为自己的API路径。\r\n\r\n  window.swaggerUi = new SwaggerUi({\r\n  url: \"/api/api-docs\",\r\n  dom_id: \"swagger-ui-container\",\r\n最后，为了能访问到该页面，还需要在Service的Initialize方法中，添加AssetsBundle\r\n\r\npublic void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {\r\n    //指定配置文件的名字\r\n    bootstrap.setName(\"helloWorld\");\r\n    bootstrap.addBundle(new AssetsBundle(\"/assets\", \"/\", \"index.html\"));\r\n}\r\n最后的效果图： \r\n\r\n\r\n\r\n\r\n\r\n三、评价\r\nSwagger可以充当前后端交流的重要桥梁，方便快捷。很实用。\r\n\r\nSwagger项目允许你生产，显示和消费你自己的RESTful服务。不需要代理和第三方服务。是一个依赖自由的资源集合，它能通过Swagger API动态的生成漂亮的文档和沙盒,因为Swagger UI没有依赖，你可以把他部署到任何服务器环境或者是你自己的机器。\r\n\r\n四、参考资料\r\n官网：http://swagger.io/\r\n\r\nGitHub：\r\n\r\nswagger-springmvc:https://github.com/martypitt/swagger-springmvc\r\n\r\nswagger-ui:https://github.com/swagger-api/swagger-ui\r\n\r\nswagger-core:https://github.com/swagger-api/swagger-core\r\n\r\nswagger-spec：https://github.com/swagger-api/swagger-spec\r\n————————————————\r\n版权声明：本文为CSDN博主「GhostStories」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/wangnan9279/article/details/44541665', 'https://i.picsum.photos/id/851/800/450.jpg', '原创', 92, 0, 0, 0, 1, 1, '2018-02-21 13:30:39', '2020-03-13 02:36:31', 1, 2, 'Swagger 是一套基于 OpenAPI 规范构建的开源工具，可以帮助我们设计、构建、记录以及使用 Rest API。Swagger 主要包含了以下两个部分：\r\nSwagger Editor：基于浏览器的编辑器，我们可以使用它编写我们 OpenAPI 规范。\r\nSwagger UI：它会将我们编写的 OpenAPI 规范呈现为交互式的 API 文档，后文我将使用浏览器来查看并且操作我们的 Rest\r\n', '15,16');
INSERT INTO `t_blog` VALUES (8, 'editormd嵌入markdown文档', ':tw-1f004:最近用**Springboot 2.x**开发了一个博客，现在一直流行markdown进行文档编辑，我也用这种方式进行文档录入，找到了一个框架**editor**开始以为挺简单，没想到花了好几个小时来增加这个功能，因为没有比较完整的文档所以踩了很多坑，写这个也希望大家有前车之鉴。\r\n#### 一、Markdown和editor.md简介：\r\n	Markdown在技术圈里（估计更多是程序猿吧）越来越流行。简单的语法，统一的格式，使用过程中，手基本上不用从键盘上移到鼠标上去，超级方便。写好了一篇md文档(也就是含Markdown语法格式的普通TXT文件)，可以随意放到别的支持Markdown格式的网站上发布。\r\n	editor.md是国内开源的一款在线Markdown编辑器，单纯基于前端JavaScript实现，和后端什么语言无关。这个还可以画流程图，以及数学公式。官网Demo示例使用的是PHP语言，我后端使用的是Java，Springmvc。\r\n	如下记录我在个人开源项目17Smart中使用的方法和过程。17Smart源码目前托管在Github上，感兴趣的可以参考了解。\r\n\r\n#### 二、editor.md的使用：\r\n2.1、下载：\r\n我们可以从其官网中找到下载最新版V1.5.0，解压资源包如下图：\r\n\r\n\r\n>1.examples文件中是使用PHP做的所有示例(可以在文档编辑器里打开，并查看源代码)；\r\n>2.lib中是editor.md所依赖的第三方js资源；\r\n>3.plugins中是如emoji表情支持、代码格式化等插件；\r\n2.2、简单使用：\r\n将上面的解压的editormd资源文件拷贝（选取需要的）到我们的项目适合目录下面。\r\n\r\n2.2.1、在自己的页面上引入相关的css和js，代码如下：\r\n<link rel=\"stylesheet\"href=\"/smart-api/htdocs/mdeditor/css/editormd.css\" />\r\n\r\n<script src=\"/smart-api/htdocs/mdeditor/js/jquery.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/js/editormd.min.js\"></script>\r\n2.2.2、在自己的页面中加上DIV：\r\nDIV的id为my-editormd（这个div在form表单中）。DIV中包含二个textarea，其实官方demo中只有一个，第二个是否方便我们POST提交时，后端可以获取到md文档内容，如java中request.getParameter(\"my-editormd-html-code\")。\r\n\r\n<div id=\"my-editormd\" >\r\n<textarea id=\"my-editormd-markdown-doc\" name=\"my-editormd-markdown-doc\" style=\"display:none;\"></textarea>\r\n<!-- 注意：name属性的值-->\r\n<textarea id=\"my-editormd-html-code\" name=\"my-editormd-html-code\" style=\"display:none;\"></textarea>\r\n</div>\r\n这里值得注意两点：\r\n>1.后端要想获得第二个textarea中的值，首先需要打开editor.md的saveHTMLToTextarea : true设置（见下面）；\r\n>2.textarea中name属性值，应该跟着div的IDmy-editormd值来定，即$-html-code（刚开始，后端死活获取不到值，翻看了源码才知道）\r\n2.2.3、在同页面中再加上如下JS代码：\r\n<script type=\"text/javascript\">\r\n  $(function() {\r\n      editormd(\"my-editormd\", {//注意1：这里的就是上面的DIV的id属性值\r\n          width   : \"90%\",\r\n          height  : 640,\r\n          syncScrolling : \"single\",\r\n          path    : \"/smart-api/htdocs/mdeditor/lib/\",//注意2：你的路径\r\n          saveHTMLToTextarea : true//注意3：这个配置，方便post提交表单\r\n      });\r\n  });\r\n</script>\r\n这里值得注意三点：\r\n\r\n>1.注意1：这里的就是上面的DIV的id属性值；\r\n>2.注意2：你的path路径（原资源文件中lib包在我们项目中所放的位置）；\r\n>3.注意3：saveHTMLToTextarea 设置true或false关乎后端是否可以获取到值；\r\n这样我们就完成了一个最简单的editor.md的编辑器了，我们可以在这里面书写自己熟悉的Markdown文档，包括代码，右侧有实时预览。\r\n\r\n2.3、上传图片：\r\n上面最简单的editor.md的编辑器，目前还是不可以上传图片的。我们需要略作配置修改，还是很简单的。\r\n\r\n我们都知道在编写Markdown文档时，图片语法是![说明](url地址)。可是，往往我们需要上传本地图片。在上面的基础之上，略做如下修改即可（当然后端的代码得自己写）：\r\n\r\n<script type=\"text/javascript\">\r\n  $(function() {\r\n      editormd(\"my-editormd\", {//注意1：这里的就是上面的DIV的id属性值\r\n          width   : \"90%\",\r\n          height  : 640,\r\n          syncScrolling : \"single\",\r\n          path    : \"/smart-api/htdocs/mdeditor/lib/\",//注意2：你的路径\r\n          saveHTMLToTextarea : true,//注意3：这个配置，方便post提交表单\r\n\r\n         /**上传图片相关配置如下*/\r\n         imageUpload : true,\r\n         imageFormats : [\"jpg\", \"jpeg\", \"gif\", \"png\", \"bmp\", \"webp\"],\r\n         imageUploadURL : \"/smart-api/upload/editormdPic/\",//注意你后端的上传图片服务地址\r\n      });\r\n  });\r\n</script>\r\n注意：editor.md期望你上传图片的服务返回如下json格式的内容\r\n\r\n{\r\n    success : 0 | 1, //0表示上传失败;1表示上传成功\r\n    message : \"提示的信息\",\r\n    url     : \"图片地址\" //上传成功时才返回\r\n}\r\n\r\n我的后台使用的是springmvc，代码如下:\r\n（注意：@RequestParam(value = \"editormd-image-file\", required = true注解）\r\n\r\n@RequestMapping(\"editormdPic\")\r\n@ResponseBody\r\npublic JSONObject editormdPic (@RequestParam(value = \"editormd-image-file\", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{\r\n\r\n        String trueFileName = file.getOriginalFilename();\r\n\r\n        String suffix = trueFileName.substring(trueFileName.lastIndexOf(\".\"));\r\n        String fileName = System.currentTimeMillis()+\"_\"+CommonUtils.getRandomNumber(100, 999)+suffix;\r\n        String path = request.getSession().getServletContext().getRealPath(\"/assets/msg/upload/\");\r\n        System.out.println(path);\r\n\r\n        File targetFile = new File(path, fileName);\r\n        if(!targetFile.exists()){\r\n           targetFile.mkdirs();\r\n        }\r\n\r\n       //保存\r\n        try {\r\n           file.transferTo(targetFile);\r\n        } catch (Exception e) {\r\n           e.printStackTrace();\r\n        }\r\n\r\n\r\n        JSONObject res = new JSONObject();\r\n        res.put(\"url\", Constant.WEB_ROOT+\"assets/msg/upload/\"+fileName);\r\n        res.put(\"success\", 1);\r\n        res.put(\"message\", \"upload success!\");\r\n\r\n        return res;\r\n\r\n    }\r\n2.4、Markdown文档页面展示：\r\n上面我们通过post提交，后端获取到MD文档内容后，往往存在数据库中，然后在页面展示时，我们需要把MD语法文档，转换为HTML语法（也可以先转换为标准的HTML存储，但我觉得先转换的话，会占用较多存储空间）。\r\n\r\n首先引入必要JS（下面不是所有必要）：\r\n\r\n<script src=\"/smart-api/htdocs/mdeditor/js/jquery.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/marked.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/prettify.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/raphael.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/underscore.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/sequence-diagram.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/flowchart.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/lib/jquery.flowchart.min.js\"></script>\r\n<script src=\"/smart-api/htdocs/mdeditor/js/editormd.min.js\"></script>\r\n然后，本页面中，加入如下DIV：\r\n<div id=\"doc-content\">\r\n    <textarea style=\"display:none;\">${message.detail }</textarea>\r\n</div>\r\n最后，再引入如下JS代码：\r\n<script type=\"text/javascript\">\r\n    var testEditor;\r\n    $(function () {\r\n        testEditor = editormd.markdownToHTML(\"doc-content\", {//注意：这里是上面DIV的id\r\n            htmlDecode: \"style,script,iframe\",\r\n            emoji: true,\r\n            taskList: true,\r\n            tex: true, // 默认不解析\r\n            flowChart: true, // 默认不解析\r\n            sequenceDiagram: true, // 默认不解析\r\n            codeFold: true,\r\n    });});\r\n </script>\r\n#### 三、editor.md的更多配置项：\r\n这配置，可以根据官方提供的Demo和源码找到（editor.md-master/examples目录下面）。如，主题颜色设置；上传图片后的特殊处理等。\r\n\r\n    <script type=\"text/javascript\">\r\n            var myEditor;\r\n\r\n            $(function() {\r\n                myEditor = editormd(\"my-editormd\", {\r\n                    width   : \"90%\",\r\n                    height  : 800,\r\n                    syncScrolling : \"single\",\r\n                    path    : \"/smart-api/htdocs/mdeditor/lib/\",\r\n                    saveHTMLToTextarea : true,\r\n\r\n                    emoji: true,//emoji表情，默认关闭\r\n                    taskList: true,\r\n                    tocm: true, // Using [TOCM]\r\n                    tex: true,// 开启科学公式TeX语言支持，默认关闭\r\n\r\n                    flowChart: true,//开启流程图支持，默认关闭\r\n                    sequenceDiagram: true,//开启时序/序列图支持，默认关闭,\r\n\r\n                    dialogLockScreen : false,//设置弹出层对话框不锁屏，全局通用，默认为true\r\n                    dialogShowMask : false,//设置弹出层对话框显示透明遮罩层，全局通用，默认为true\r\n                    dialogDraggable : false,//设置弹出层对话框不可拖动，全局通用，默认为true\r\n                    dialogMaskOpacity : 0.4, //设置透明遮罩层的透明度，全局通用，默认值为0.1\r\n                    dialogMaskBgColor : \"#000\",//设置透明遮罩层的背景颜色，全局通用，默认为#fff\r\n\r\n                    codeFold: true,\r\n\r\n                    imageUpload : true,\r\n                    imageFormats : [\"jpg\", \"jpeg\", \"gif\", \"png\", \"bmp\", \"webp\"],\r\n                    imageUploadURL : \"/smart-api/upload/editormdPic/\",\r\n\r\n                    /*上传图片成功后可以做一些自己的处理*/\r\n                    onload: function () {\r\n                        //console.log(\'onload\', this);\r\n                        //this.fullscreen();\r\n                        //this.unwatch();\r\n                        //this.watch().fullscreen();\r\n                        //this.width(\"100%\");\r\n                        //this.height(480);\r\n                        //this.resize(\"100%\", 640);\r\n                    },\r\n\r\n                    /**设置主题颜色*/\r\n                    editorTheme: \"pastel-on-dark\",\r\n                    theme: \"gray\",\r\n                    previewTheme: \"dark\"\r\n                });\r\n\r\n            });\r\n        </script>\r\n————————————————\r\n\r\n\r\n', 'https://i.picsum.photos/id/852/800/450.jpg', '原创', 211, 1, 0, 1, 1, 1, '2020-02-22 06:24:05', '2020-02-23 05:38:08', 9, 2, '最近用Springboot 2.x开发了一个博客，现在一直流行markdown进行文档编辑，我也用这种方式进行文档录入，找到了一个框架editor开始以为挺简单，没想到花了好几个小时来增加这个功能，因为没有比较完整的文档所以踩了很多坑，写这个也希望大家有前车之鉴', '15,16,14');
INSERT INTO `t_blog` VALUES (9, 'SpringMVC简介', '### 为什么要使用springMVC？\r\n很多应用程序的问题在于处理业务数据和显示业务数据的视图的对象之间存在紧密耦合。通常，更新业务对象的命令都是从视图本身发起的，使视图对任何业务对象更改都有高度敏感性。而且，当多个视图依赖于同一个业务对象时是没有灵活性的。\r\n\r\nSpring Web MVC是一种基于Java的实现了Web MVC设计模式的请求驱动类型的轻量级Web框架，即使用了MVC架构模式的思想，将web层进行职责解耦，基于请求驱动指的就是使用请求-响应模型，框架的目的就是帮助我们简化开发，Spring Web MVC也是要简化我们日常Web开发的。\r\n\r\n###  MVC设计模型\r\nMVC 是一种著名的设计模式，特别是在 Web 应用程序领域。模式全都是关于将包含业务数据的模块与显示模块的视图解耦的。这是怎样发生的？视图（例如，JSP 页面）怎样能够与其模型（例如，包含数据的 JavaBean）解耦？记得这句格言么？一个层次的重定向几乎可以解决计算机业中的所有问题。确实，在模型和视图之间引入重定向层可以解决问题。此重定向层是控制器。控制器将接收请求，执行更新模型的操作，然后通知视图关于模型更改的消息。依赖于模型的状态并且依赖于请求的控制器可以决定要显示哪个视图。\r\n\r\n \r\n\r\n### springMVC的强大之处\r\n1.Spring MVC 实现了即用的 MVC 的核心概念。它为控制器和处理程序提供了大量与此模式相关的功能。并且当向 MVC 添加反转控制（Inversion of Control，IoC）时，它使应用程序高度解耦，提供了通过简单的配置更改即可动态更改组件的灵活性。Spring MVC 为您提供了完全控制应用程序的各个方面的力量。\r\n\r\n2.Spring 的 Web MVC 模块是围绕 DispatcherServlet 而设计的。DispatcherServlet 给处理程序分派请求，执行视图解析，并且处理语言环境和主题解析，此外还为上传文件提供支持。\r\n\r\n3.DispatcherServlet 通过使用处理程序映射来决定哪一个处理程序应当处理传入的请求。处理程序映射只是用于标识使用哪一个处理程序来处理特定 URL 模式的映射。处理程序是只有一种方法 ModelAndView handleRequest(request,response) 的控制器接口的实现。Spring 还有一些可用的高级处理程序实现；其中一个重要的高级处理程序实现是 SimpleFormController，它提供了将命令对象绑定到表单、对其执行验证等功能。\r\n\r\n4.您已经在本系列教程的先前教程中使用了 DispatcherServlet 和简单的处理程序。在下一个部分中，将使用 SimpleFormController 并说明 Spring MVC 提供的各种即用功能。\r\n\r\nspringMVC优势\r\n1、清晰的角色划分：前端控制器（DispatcherServlet）、请求到处理器映射（HandlerMapping）、处理器适配器（HandlerAdapter）、视图解析器（ViewResolver）、处理器或页面控制器（Controller）、验证器（ Validator）、命令对象（Command  请求参数绑定到的对象就叫命令对象）、表单对象（Form Object 提供给表单展示和提交到的对象就叫表单对象）。\r\n\r\n2、分工明确，而且扩展点相当灵活，可以很容易扩展，虽然几乎不需要；\r\n\r\n3、由于命令对象就是一个POJO，无需继承框架特定API，可以使用命令对象直接作为业务对象；\r\n\r\n4、和Spring 其他框架无缝集成，是其它Web框架所不具备的；\r\n\r\n5、可适配，通过HandlerAdapter可以支持任意的类作为处理器；\r\n\r\n6、可定制性，HandlerMapping、ViewResolver等能够非常简单的定制；\r\n\r\n7、功能强大的数据验证、格式化、绑定机制；\r\n\r\n8、利用Spring提供的Mock对象能够非常简单的进行Web层单元测试；\r\n\r\n9、本地化、主题的解析的支持，使我们更容易进行国际化和主题的切换。\r\n\r\n10、强大的JSP标签库，使JSP编写更容易。\r\n\r\n………………还有比如RESTful风格的支持、简单的文件上传、约定大于配置的契约式编程支持、基于注解的零配置支持等等。\r\n\r\n \r\n\r\n springMVC的运行原理\r\n \r\n\r\n架构图\r\n\r\n\r\n \r\n\r\n首先让我们了解下 MVC（Model-View-Controller）三元组的概念：\r\n\r\nModel（模型）：数据模型，提供要展示的数据，因此包含数据和行为，可以认为是领域模型或 JavaBean 组件（包含数据和行为），不过现在一般都分离开来：Value Object（数据） 和 服务层（行为）。也就是模型提供了模型数据查询和模型数据的状态更新等功能，包括数据和业务。\r\n\r\n领域模型\r\n\r\njavaBean组件等价于 域模型层 + 业务逻辑层 + 持久层\r\n\r\nView(视图):负责进行模型的展示，一般就是我们见到的用户界面，客户想看到的东西。\r\n\r\nController(控制器):接收用户请求，委托给模型进行处理（状态改变），处理完毕后把返回的模型数据返回给视图，\r\n\r\n由视图负责展示。 也就是说控制器做了个调度员的工作，。\r\n\r\n \r\n\r\n### Springmvc运行原理流程\r\n\r\n\r\n核心架构的具体流程步骤如下：\r\n\r\n1、  首先用户发送请求——>DispatcherServlet，前端控制器收到请求后自己不进行处理，而是委托给其他的解析器进行处理，作为统一访问点，进行全局的流程控制；\r\n\r\n2、DispatcherServlet——>HandlerMapping,HandlerMapping将会把请求映射为HandlerExecutionChain对象（包含一个Handler处理器（页面控制器）对象、多个HandlerInterceptor拦截器）对象，通过这种策略模式，很容易添加新的映射策略；\r\n\r\n3、  DispatcherServlet——>HandlerAdapter，HandlerAdapter将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用，从而很容易支持很多类型的处理器；\r\n\r\n4、  HandlerAdapter——>处理器功能处理方法的调用，HandlerAdapter将会根据适配的结果调用真正的处理器的功能处理方法，完成功能处理；并返回一个ModelAndView对象（包含模型数据、逻辑视图名）；\r\n\r\n5、  ModelAndView的逻辑视图名——> ViewResolver， ViewResolver将把逻辑视图名解析为具体的View，通过这种策略模式，很容易更换其他视图技术；\r\n\r\n6、  View——>渲染，View会根据传进来的Model模型数据进行渲染，此处的Model实际是一个Map数据结构，因此很容易支持其他视图技术；\r\n\r\n7、返回控制权给DispatcherServlet，由DispatcherServlet返回响应给用户，到此一个流程结束。\r\n\r\n \r\n\r\n###  组件说明\r\n \r\n\r\n以下组件通常使用框架提供实现：\r\n\r\n \r\n\r\nu DispatcherServlet：前端控制器\r\n\r\n \r\n\r\n用户请求到达前端控制器，它就相当于mvc模式中的c，dispatcherServlet是整个流程控制的中心，由它调用其它组件处理用户的请求，dispatcherServlet的存在降低了组件之间的耦合性。\r\n\r\n \r\n\r\nu HandlerMapping：处理器映射器\r\n\r\n \r\n\r\nHandlerMapping负责根据用户请求找到Handler即处理器，springmvc提供了不同的映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。\r\n\r\n \r\n\r\nu Handler：处理器\r\n\r\n \r\n\r\nHandler 是继DispatcherServlet前端控制器的后端控制器，在DispatcherServlet的控制下Handler对具体的用户请求进行处理。\r\n\r\n \r\n\r\n由于Handler涉及到具体的用户业务请求，所以一般情况需要程序员根据业务需求开发Handler。\r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\nu HandlAdapter：处理器适配器\r\n\r\n \r\n\r\n通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行。\r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\nu View Resolver：视图解析器\r\n\r\n \r\n\r\nView Resolver负责将处理结果生成View视图，View Resolver首先根据逻辑视图名解析成物理视图名即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。\r\n\r\n \r\n\r\nu View：视图\r\n\r\n \r\n\r\nspringmvc框架提供了很多的View视图类型的支持，包括：jstlView、freemarkerView、pdfView等。我们最常用的视图就是jsp。\r\n\r\n \r\n\r\n一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由程序员根据业务需求开发具体的页面。\r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\n### 注解描述：\r\n\r\n \r\n\r\n@RequestMapping：定义请求url到处理器功能方法的映射\r\n\r\n \r\n\r\n RequestMappingHandlerAdapter\r\n \r\n\r\n注解式处理器适配器，对标记@ResquestMapping的方法进行适配。\r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\n从spring3.1版本开始，废除了AnnotationMethodHandlerAdapter的使用，推荐使用RequestMappingHandlerAdapter完成注解式处理器适配。\r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\n### 配置如下：\r\n\r\n \r\n\r\n<!--注解适配器 -->\r\n    <bean class=\"org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter\"/>\r\n<mvc:annotation-driven>\r\nspringmvc使用<mvc:annotation-driven>自动加载RequestMappingHandlerMapping和RequestMappingHandlerAdapter，可用在springmvc.xml配置文件中使用<mvc:annotation-driven>替代注解处理器和适配器的配置。\r\n\r\n \r\n\r\n1.1 视图解析器\r\n \r\n\r\n在springmvc.xml文件配置如下：\r\n\r\n \r\n\r\n \r\n\r\n复制代码\r\n<bean class=\"org.springframework.web.servlet.view.InternalResourceViewResolver\">\r\n\r\n<property name=\"viewClass\"\r\n\r\nvalue=\"org.springframework.web.servlet.view.JstlView\" />\r\n\r\n<property name=\"prefix\" value=\"/WEB-INF/jsp/\" />\r\n\r\n<property name=\"suffix\" value=\".jsp\" />\r\n\r\n</bean>\r\n复制代码\r\n \r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\n \r\n\r\nInternalResourceViewResolver：支持JSP视图解析\r\n\r\n \r\n\r\nviewClass：JstlView表示JSP模板页面需要使用JSTL标签库，所以classpath中必须包含jstl的相关jar 包。此属性可以不设置，默认为JstlView。\r\n\r\n \r\n\r\nprefix 和suffix：查找视图页面的前缀和后缀，最终视图的址为：\r\n\r\n \r\n\r\n前缀+逻辑视图名+后缀，逻辑视图名需要在controller中返回ModelAndView指定，比如逻辑视图名为hello，则最终返回的jsp视图地址 “WEB-INF/jsp/hello.jsp”\r\n\r\n DispatcherServlet核心代码分析\r\n\r\n \r\n\r\n复制代码\r\n//前端控制器分派方法  \r\nprotected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {  \r\n        HttpServletRequest processedRequest = request;  \r\n        HandlerExecutionChain mappedHandler = null;  \r\n        int interceptorIndex = -1;\r\n        try {  \r\n            ModelAndView mv;  \r\n            boolean errorView = false;    \r\n            try {  \r\n        //检查是否是请求是否是multipart（如文件上传），如果是将通过MultipartResolver解析  \r\n                processedRequest = checkMultipart(request);  \r\n         //步骤2、请求到处理器（页面控制器）的映射，通过HandlerMapping进行映射  \r\n                mappedHandler = getHandler(processedRequest, false);  \r\n                if (mappedHandler == null || mappedHandler.getHandler() == null) {  \r\n                    noHandlerFound(processedRequest, response);  \r\n                    return;  \r\n                }  \r\n //步骤3、处理器适配，即将我们的处理器包装成相应的适配器（从而支持多种类型的处理器）  \r\n                HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());    \r\n                // 304 Not Modified缓存支持  \r\n                //此处省略具体代码    \r\n                // 执行处理器相关的拦截器的预处理（HandlerInterceptor.preHandle）  \r\n                //此处省略具体代码    \r\n                // 步骤4、由适配器执行处理器（调用处理器相应功能处理方法）  \r\n                mv = ha.handle(processedRequest, response, mappedHandler.getHandler());    \r\n                // Do we need view name translation?  \r\n                if (mv != null && !mv.hasView()) {  \r\n                    mv.setViewName(getDefaultViewName(request));  \r\n                }    \r\n                // 执行处理器相关的拦截器的后处理（HandlerInterceptor.postHandle）  \r\n                //此处省略具体代码  \r\n            }  \r\n            catch (ModelAndViewDefiningException ex) {  \r\n                logger.debug(\"ModelAndViewDefiningException encountered\", ex);  \r\n                mv = ex.getModelAndView();  \r\n            }  \r\n            catch (Exception ex) {  \r\n                Object handler = (mappedHandler != null ? mappedHandler.getHandler() : null);  \r\n                mv = processHandlerException(processedRequest, response, handler, ex);  \r\n                errorView = (mv != null);  \r\n            }    \r\n//步骤5 步骤6、解析视图并进行视图的渲染  \r\n//步骤5 由ViewResolver解析View（viewResolver.resolveViewName(viewName, locale)）  \r\n步骤6 视图在渲染时会把Model传入（view.render(mv.getModelInternal(), request, response);）  \r\n            if (mv != null && !mv.wasCleared()) {  \r\n                render(mv, processedRequest, response);  \r\n                if (errorView) {  \r\n                    WebUtils.clearErrorRequestAttributes(request);  \r\n                }  \r\n            }  \r\n            else {  \r\n                if (logger.isDebugEnabled()) {  \r\n                    logger.debug(\"Null ModelAndView returned to DispatcherServlet with name \'\" + getServletName() +  \r\n                            \"\': assuming HandlerAdapter completed request handling\");  \r\n                }  \r\n            }    \r\n            // 执行处理器相关的拦截器的完成后处理（HandlerInterceptor.afterCompletion）  \r\n            //此处省略具体代码    \r\n        catch (Exception ex) {  \r\n            // Trigger after-completion for thrown exception.  \r\n            triggerAfterCompletion(mappedHandler, interceptorIndex, processedRequest, response, ex)            throw ex;  \r\n        }  \r\n        catch (Error err) {  \r\n            ServletException ex = new NestedServletException(\"Handler processing failed\", err);  \r\n            // Trigger after-completion for thrown exception.  \r\n            triggerAfterCompletion(mappedHandler, interceptorIndex, processedRequest, response, ex);  \r\n            throw ex;  \r\n        }    \r\n        finally {  \r\n            // Clean up any resources used by a multipart request.  \r\n            if (processedRequest != request) {\r\n                cleanupMultipart(processedRequest);  \r\n            }  \r\n        }  \r\n    }  ', 'https://i.picsum.photos/id/864/800/450.jpg', '转载', 591, 0, 0, 1, 1, 1, '2019-02-22 06:51:07', '2019-02-23 06:52:17', 5, 2, 'Spring Web MVC是一种基于Java的实现了Web MVC设计模式的请求驱动类型的轻量级Web框架，即使用了MVC架构模式的思想，将web层进行职责解耦，基于请求驱动指的就是使用请求-响应模型，框架的目的就是帮助我们简化开发，Spring Web MVC也是要简化我们日常Web开发', '13,14,16');

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` bigint(20) NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES (1, 15, 5);
INSERT INTO `t_blog_tags` VALUES (2, 16, 5);
INSERT INTO `t_blog_tags` VALUES (3, 14, 6);
INSERT INTO `t_blog_tags` VALUES (4, 15, 7);
INSERT INTO `t_blog_tags` VALUES (5, 15, 8);
INSERT INTO `t_blog_tags` VALUES (6, 16, 8);
INSERT INTO `t_blog_tags` VALUES (7, 14, 8);
INSERT INTO `t_blog_tags` VALUES (8, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (9, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (10, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (11, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (12, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (13, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (14, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (15, NULL, NULL);
INSERT INTO `t_blog_tags` VALUES (16, NULL, NULL);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  `admin_comment` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (9, '小小滨', '3468449367@qq.com', '另一个父类评论', 'https://i.picsum.photos/id/865/100/100.jpg', '2020-02-23 14:06:54', 6, -1, 0);
INSERT INTO `t_comment` VALUES (10, '月夜の麋鹿', '3468449362@qq.com', '月夜麋鹿对麋鹿滨的回复', 'https://i.picsum.photos/id/863/100/100.jpg', '2020-02-23 14:22:57', 6, 8, 1);
INSERT INTO `t_comment` VALUES (12, '月夜の麋鹿', '3468449362@qq.com', '不在低调了，我就是博主...', 'https://i.picsum.photos/id/863/100/100.jpg', '2020-02-24 06:23:11', 6, -1, 1);
INSERT INTO `t_comment` VALUES (14, '月夜の麋鹿', '3468449362@qq.com', '这个评论页面真是惨不忍睹...', 'https://i.picsum.photos/id/863/100/100.jpg', '2020-02-24 11:26:32', 6, -1, 1);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (8, '指针链表');
INSERT INTO `t_tag` VALUES (9, '二叉树');
INSERT INTO `t_tag` VALUES (10, '动态规划');
INSERT INTO `t_tag` VALUES (11, '数组');
INSERT INTO `t_tag` VALUES (12, '经典排序');
INSERT INTO `t_tag` VALUES (13, 'SpringMVC ');
INSERT INTO `t_tag` VALUES (14, 'Mybatis');
INSERT INTO `t_tag` VALUES (15, 'Springboot ');
INSERT INTO `t_tag` VALUES (16, 'MySQL');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, 'Swagger-UI');
INSERT INTO `t_type` VALUES (3, 'Shiro');
INSERT INTO `t_type` VALUES (4, 'RebbitMQ');
INSERT INTO `t_type` VALUES (5, 'SpringMVC');
INSERT INTO `t_type` VALUES (6, 'SpringIOC');
INSERT INTO `t_type` VALUES (7, 'SpringAOP');
INSERT INTO `t_type` VALUES (8, 'PageHelper');
INSERT INTO `t_type` VALUES (9, 'Springboot 2.x');
INSERT INTO `t_type` VALUES (12, 'Mybatis');
INSERT INTO `t_type` VALUES (15, 'Springboot+JPA');
INSERT INTO `t_type` VALUES (16, 'Springboot+Mybatis');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(10) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (2, '月夜の麋鹿', 'mabin', '8224e9aac8fe0b96e7914d29ab10a8ac', '3468449362@qq.com', 'https://i.picsum.photos/id/863/100/100.jpg', 1, NULL, NULL, 'user:admin');

-- ----------------------------
-- Function structure for getChildList
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildList`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildList`(rootId INT) RETURNS varchar(1000) CHARSET utf8mb4
BEGIN
    DECLARE sTemp VARCHAR(1000);
    DECLARE sTempChd VARCHAR(1000);

    SET sTemp = '$';
    SET sTempChd =cast(rootId as CHAR);

    WHILE sTempChd is not null DO
    SET sTemp = concat(sTemp,',',sTempChd);
    SELECT group_concat(id) INTO sTempChd FROM t_comment where FIND_IN_SET(parent_comment_id,sTempChd)>0;
    END WHILE;
    RETURN sTemp;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
