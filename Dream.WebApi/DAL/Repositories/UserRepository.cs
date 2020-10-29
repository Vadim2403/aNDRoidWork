using Dream.WebApi.DAL.Interfaces;
using Dream.WebApi.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Dream.WebApi.DAL.Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly EFContext _context;
        public UserRepository(EFContext context)
        {
            _context = context;
        }
        public void AddUser(DbUser user)
        {
            _context.Users.Add(user);
            _context.SaveChanges();
        }
    }
}
