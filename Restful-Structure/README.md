# RESTful Structure



------



## 1、我的代码主要有三个部分：frontend、backend和api

frotend是前端，backend是后端，api是我生成restfulAPI接口的项目。

在写api项目时，就是仿照着老师给的样例和网上的样例写相应的接口，主要的步骤如下：

### 1.1 首先阅读前端代码，获得相应的http请求是什么样子。

```javascript
$.ajax({
                url: json_api + 'products/' + cart[i].id,
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({ quantity: cart[i].max_quantity - cart[i].quantity }),
                type: "PATCH",
                success: function (data) {
                    console.log("Data updated!");
                },
                error: function (data) {
                    console.log("failed");
                }
            })
```

这一段需要后端接受一个patch的http请求，数据格式是json格式，资源路径类似于：http://localhost:3000/products/PD1

### 1.2 书写后端统一由openapi生成的代码。

相应yml：

```yaml
    patch:
      summary: assign the  quantity of product
      operationId: assignNumberOfProduct
      tags:
        - product
      parameters:
        - name: productId
          in: path
          required: true
          description: The id of the product to retrieve
          schema:
            type: string
      requestBody:
        description: the reduce number of the product
        content:
          'application/json':
            schema:
              type: string
        required: true

      responses:
        '200':
            description: 商品数量修改成功 
        '400':
            description: 商品数量修改失败
        default:
          description: unexpected error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
```

相应生成的代码的interface：

```java
 default ResponseEntity<Void> assignNumberOfProduct(
        @Parameter(name = "productId", description = "The id of the product to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId,
        @Parameter(name = "body", description = "the reduce number of the product", required = true) @Valid @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
```



## 1.3  重写相应的接口函数。

controller继承api接口

```java
public class ProductsController implements ProductsApi{
```

重写函数：

```java
@Override
    public ResponseEntity<Void> assignNumberOfProduct( @PathVariable("productId") String productId, @RequestBody String body) {
        //返回内容
        ResponseEntity<Void> response = null;

        //拿到剩余的数目
        JSONObject jsonObject = JSONUtil.parseObj(body.toString());
        Integer Num = Integer.parseInt(jsonObject.getStr("quantity").toString());
        int num=Num.intValue();

        //处理逻辑
        if(posService.setStockOfProduct(num,productId)){
            response = ResponseEntity.ok().build();
        }
        else{
            response = ResponseEntity.status(400).build();
        }
        return response;
    }
```



### 3.4  中间还要写一个map函数生成框架能接受的model，使用mapstruct的包。

```json
<modelNameSuffix>Dto</modelNameSuffix>
```

```java
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T08:37:39+0800",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {
```

------



## 2. 相关视频

Related vedio ：[click here](https://www.bilibili.com/video/BV1d1421d7wf/?vd_source=4985f83853fea5fcd090f8f95973265a)



------



## 3. 相关概念理解



### 3.1  应用状态：

应用状态是指客户端关于其与服务器交互的当前阶段的状态。应用状态完全由用户来维护，比如程序中购物车就是前端在维护，后端不用管购物车里面有没有商品，有几件，只需管好自己的资源就可以了。这样做也有利于用户扩展。（程序中图片资源应该另外写一个服务器维护，而不是放到前端，不然用户手机肯定存不下这么多图片）



### 3.2  资源状态：

网络服务中的所有资源（包括服务和实体资源）由可访问的统一http url接口进行标识，并通过过规定的操作进行处理，这里就包括：GET,POST,PUT,DELETE。这些资源的状态和资源状态的转换通过相互之间没有关系的http操作来处理。比如这个应用中我购买完东西，商品数量要减少，只需要发送http patch请求，后端调用修改数量的接口就可以了，并不需要知道其他的内容。





