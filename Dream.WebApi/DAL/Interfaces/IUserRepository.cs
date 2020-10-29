using Dream.WebApi.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Dream.WebApi.DAL.Interfaces
{
    public interface IUserRepository
    {
        void AddUser(DbUser user);
    }
}
