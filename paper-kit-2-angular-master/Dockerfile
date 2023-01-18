# stage 1
FROM node:latest as build
WORKDIR /app
COPY . .
RUN npm install --save --legacy-peer-deps
RUN npm run build --prod

# stage 2
FROM nginx:alpine
COPY --from=node /app/dist/plantManagement /usr/share/nginx/html
