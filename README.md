# ComponentInARouter
### Android组件化模式使用ARouter通信的Demo

以该demo为例  
根据 gradle.properties 的 ‘isModuleRun’  
isModuleRun = true      
app        compile     module_base  
module_a   compile     module_base  
module_b   compile     module_base  

isModuleRun = false  
app        compile     module_a  
app        compile     module_b  
module_a   compile     module_base  
module_b   compile     module_base    
  
  
通过ARouter进行互不关联的module通信。  
app      <--->   module_a  
app      <--->   module_b  
module_b <--->   module_a  
module_a <--->   module_b  

