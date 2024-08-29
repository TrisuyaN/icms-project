import os

# 从标准输入读取类名
class_name = input("请输入类名: ")

# 定义文件名和对应的路径
file_info = {
    f"{class_name}.java": "./src/main/java/com/sc/scbackend/domain/",
    f"{class_name}Dao.java": "./src/main/java/com/sc/scbackend/dao/",
    f"{class_name}Service.java": "./src/main/java/com/sc/scbackend/service/",
    f"{class_name}ServiceImpl.java": "./src/main/java/com/sc/scbackend/service/impl/"
}

# 创建目录并生成空文件
for file_name, directory in file_info.items():
    # 创建目录（如果不存在）
    os.makedirs(directory, exist_ok=True)
    
    # 创建空文件
    file_path = os.path.join(directory, file_name)
    with open(file_path, 'w') as f:
        pass  # 创建空文件

print("文件已生成:")
for file_name in file_info.keys():
    print(os.path.join(file_info[file_name], file_name))
