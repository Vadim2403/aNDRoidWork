﻿using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Dream.WebApi.Entities
{
    public class SeederDB
    {
        public static void SeedData(UserManager<DbUser> userManager,
                   RoleManager<DbRole> roleManager)
        {
            var adminRoleName = "Admin";
            var userRoleName = "User";

            var roleResult = roleManager.FindByNameAsync(adminRoleName).Result;
            if (roleResult==null)
            {
                var roleresult = roleManager.CreateAsync(new DbRole
                {
                    Name = userRoleName

                }).Result;
            }
            roleResult = roleManager.FindByNameAsync(userRoleName).Result;
            if ( roleResult==null)
            {
                var roleresult = roleManager.CreateAsync(new DbRole
                {
                    Name = userRoleName

                }).Result;
            }
            

            var email = "admin@gmail.com";
            
            var findUser = userManager.FindByEmailAsync(email).Result;
            if (findUser == null)
            {
                var user = new DbUser
                {
                    Email = email,
                    UserName = email,
                    Image = "https://cdn.pixabay.com/photo/2017/07/28/23/34/fantasy-picture-2550222_960_720.jpg",
                    Age = 30,
                    Phone = "+380957476156",
                    Description = "PHP programmer"
                };
                var result = userManager.CreateAsync(user, "Qwerty1-").Result;               

                result = userManager.AddToRoleAsync(user, adminRoleName).Result;
            }

            email = "user@gmail.com";
            findUser = userManager.FindByEmailAsync(email).Result;
            if (findUser == null)
            {
                var user = new DbUser
                {
                    Email = email,
                    UserName = email,
                    Image = "https://cdn.pixabay.com/photo/2017/07/28/23/34/fantasy-picture-2550222_960_720.jpg",
                    Age = 30,
                    Phone = "+380988005535",
                    Description = "User"
                };
                var result = userManager.CreateAsync(user, "Qwerty1-").Result;                

                result = userManager.AddToRoleAsync(user, userRoleName).Result;
            }
        }

        public static void SeedDataByAS(IServiceProvider services)
        {
            using (var scope = services.GetRequiredService<IServiceScopeFactory>().CreateScope())
            {
                var manager = scope.ServiceProvider.GetRequiredService<UserManager<DbUser>>();
                var managerRole = scope.ServiceProvider.GetRequiredService<RoleManager<DbRole>>();
                var context = scope.ServiceProvider.GetRequiredService<EFContext>();
                SeederDB.SeedData(manager, managerRole);
                string cityname = "Рівне";
                var city = context.Cities.FirstOrDefault(x => x.Name == cityname);
                if (city == null)
                {
                    city = new City { Name = cityname };
                    context.Cities.Add(city);
                    context.SaveChanges();
                }



                string universityName = "Рівненський державний гуманітарний університет";
                var university = context.Universities.FirstOrDefault(x => x.Name == universityName);
                if(university==null)
                {
                    university = new University
                    {
                        Name = universityName,
                        Image = "https://www.rshu.edu.ua/images/djmediatools/1-front/header.jpg",
                        CityId = city.Id
                    };
                    context.Universities.Add(university);
                    context.SaveChanges();
                }
            }
        }
    }

}