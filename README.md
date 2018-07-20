# ComponentInARouter
### Android组件化模式使用ARouter通信的Demo

以该demo为例，组件化的结构 
根据 gradle.properties 的 ‘isModuleRun’  
##### isModuleRun = true      
app        compile     module_base  
module_a   compile     module_base  
module_b   compile     module_base  

##### isModuleRun = false  
app &emsp;&emsp;&emsp;&ensp; compile   &emsp;&emsp;&emsp;  module_a  
app &emsp;&emsp;&emsp;&ensp; compile   &emsp;&emsp;&emsp;  module_b  
module_a &emsp;   compile  &emsp;&emsp;&emsp;   module_base  
module_b &emsp;   compile  &emsp;&emsp;&emsp;   module_base    
  
  
#### 通过ARouter进行互不关联的module通信。  
module_b &emsp;<---> &emsp;  module_a  
module_a &emsp;<---> &emsp;  module_b  

