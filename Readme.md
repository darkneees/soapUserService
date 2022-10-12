# Add Request

- Получить всех юзеров без ролей и сетей .
- Получить все роли .
- Получить пользователя по username .
- Добавить пользователя .
- Удалить пользователя .
- Удалить роль у пользователя .
- Добавить пользователю роль
- Редактировать пользователя .

Запрос для добавления пользователя:
- Социальные сети опциональны
- Роли опциональны
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:api="http://users-soap/api/">
   <soapenv:Header/>
   <soapenv:Body>
      <api:addUserRequest>
         <api:user>
            <api:username>dark</api:username>
            <api:firstName>Mask</api:firstName>
            <api:secondName>Ilon</api:secondName>
            <api:age>43</api:age>
            <api:password>pass</api:password>
            <!--1 or more repetitions:-->
            <api:socialList>
               <api:nameSocial>TG</api:nameSocial>
               <api:identifierSocial>TG</api:identifierSocial>
            </api:socialList>
             <api:socialList>
               <api:nameSocial>VK</api:nameSocial>
               <api:identifierSocial>VK</api:identifierSocial>
            </api:socialList>
            <!--1 or more repetitions:-->
            <api:roleList>
               <api:id>1</api:id>
            </api:roleList>
             <api:roleList>
               <api:id>2</api:id>
            </api:roleList>
         </api:user>
      </api:addUserRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

Запрос для получения всех пользователей:

```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:api="http://users-soap/api/">
   <soapenv:Header/>
   <soapenv:Body>
      <api:getAllUsersRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```

Запрос для полуения всех ролей:
```

```