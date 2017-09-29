# 核心技术架构

## 菜单初始化
* 通过注解进行解析
```java
@Controller
@Module(name = "系统管理", order = 1, description = "核心功能")
public class SystemModuleTestController {

    @RequestMapping("sys/userMgt.html")
    @Menu(path = "sys/userMgt.html", title = "用户管理", icon = "userMgt.jpg")
    public String userManagement() {
        return "system/userManagement";
    }

    @RequestMapping("sys/roleMgt.html")
    @Menu(path = "sys/routeMgt.html", title = "角色管理", icon = "roleMgt.jpg")
    public String roleManagement() {
        return "system/roleManagement";
    }
}
```
